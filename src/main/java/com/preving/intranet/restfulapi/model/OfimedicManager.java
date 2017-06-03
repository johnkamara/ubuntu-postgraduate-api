package com.preving.intranet.restfulapi.model;

import com.preving.intranet.restfulapi.model.dao.OfimedicDao;
import com.preving.intranet.restfulapi.model.domain.OfimedicCita;
import com.preving.intranet.restfulapi.model.exceptions.CustomRestApiException;
import com.preving.intranet.restfulapi.model.exceptions.errors.RestApiErrorCode;
import com.preving.intranet.restfulapi.model.exceptions.errors.RestApiErrorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by javier-montesinos on 31/05/17.
 */
@Service
public class OfimedicManager implements OfimedicService {

    @Autowired
    private OfimedicDao dao;

    @Override
    public void save(List<OfimedicCita> citas) {
        // Almacena los errores de validación para cada cita
        List<RestApiErrorDetail> erroresValidacion = new ArrayList<>();

        // Almacena los errores de validación de todas las citas
        List<RestApiErrorDetail> erroresValidacionReturn = new ArrayList<>();

        // Almacena los errores durante el proceso
        List<RestApiErrorDetail> errores = new ArrayList<>();

        for(OfimedicCita cita : citas){
            boolean citaCorrecta = this.validarCita(cita, erroresValidacion);
            if(citaCorrecta) {
                try {
                    this.dao.save(cita);
                    cita.setProcesadaEstado(OfimedicCita.ESTADO_PROCESADO_OK);
                    cita.setProcesadaFecha(new Date());
                } catch(Exception e) {
                    cita.setProcesadaEstado(OfimedicCita.ESTADO_PROCESADO_ERROR);
                    e.printStackTrace();
                    errores.add(new RestApiErrorDetail("error (id = " + cita.getId() + ")", e.getMessage()));
                }
            } else {
                erroresValidacionReturn.addAll(erroresValidacion);
            }
        }

        // Devuelve una lista con los errores de validación
        if(erroresValidacionReturn.size() > 0) {
            throw new CustomRestApiException(HttpStatus.PRECONDITION_FAILED, RestApiErrorCode.ERROR_VALIDACION_CITAS,
                    erroresValidacionReturn);
        }

        // Devuelve una lista con los errores en el proceso
        if(errores.size() > 0) {
            throw new CustomRestApiException(HttpStatus.INTERNAL_SERVER_ERROR, RestApiErrorCode.ERROR_CITAS,
                    errores);
        }
    }

    private boolean validarCita(OfimedicCita cita, List<RestApiErrorDetail> errores){
        boolean validado = true;

        // origen: 1 - PREVING, 2 - ASEM
        if(cita.getOrigen() != 1 && cita.getOrigen() != 2) {
            validado = false;
            errores.add(new RestApiErrorDetail("error.validacion.origen (id = " + cita.getId() + ")",
                    RestApiErrorCode.ERROR_VALIDACION_CITAS_ORIGEN.getMessage()));
        }

        // origenCitaId obligatorio
        if(cita.getOrigenCitaId() <= 0) {
            validado = false;
            errores.add(new RestApiErrorDetail("error.validacion.origenCitaId (id = " + cita.getId() + ")",
                    RestApiErrorCode.ERROR_VALIDACION_CITAS_ORIGENCITAID.getMessage()));
        }

        // fecha obligatorio
        if(cita.getFecha() == null) {
            validado = false;
            errores.add(new RestApiErrorDetail("error.validacion.fecha id = (" + cita.getId() + ")",
                    RestApiErrorCode.ERROR_VALIDACION_CITAS_FECHA.getMessage()));
        }

        // medico obligatorio
        if(cita.getMedico() == null || cita.getMedico().equals("")) {
            validado = false;
            errores.add(new RestApiErrorDetail("error.validacion.medico id = (" + cita.getId() + ")",
                    RestApiErrorCode.ERROR_VALIDACION_CITAS_MEDICO.getMessage()));
        }

        // cliente obligatorio
        if(cita.getCliente() == null || cita.getCliente().equals("")) {
            validado = false;
            errores.add(new RestApiErrorDetail("error.validacion.cliente id = (" + cita.getId() + ")",
                    RestApiErrorCode.ERROR_VALIDACION_CITAS_CLIENTE.getMessage()));
        }

        // estado pendiente
        if(cita.getProcesadaEstado() != 0) {
            validado = false;
            errores.add(new RestApiErrorDetail("error.validacion.estado id = (" + cita.getId() + ")",
                    RestApiErrorCode.ERROR_VALIDACION_CITAS_ESTADO.getMessage()));
        }

        return validado;
    }

    @Override
    public List<OfimedicCita> getCitasProcesadasDesdeFecha(Date desde) {
        return this.dao.getCitasProcesadasDesdeFecha(desde);
    }
}

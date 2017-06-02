package com.preving.intranet.restfulapi.model;

import com.preving.intranet.restfulapi.model.dao.OfimedicDao;
import com.preving.intranet.restfulapi.model.domain.OfimedicCita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        for(OfimedicCita cita : citas){
            boolean citaCorrecta = this.validarCita(cita);
            if(citaCorrecta){
                try {
                    this.dao.save(cita);
                } catch(Exception e) {
                    // todo fj2m añadir a lista de errores
                }
            }
        }
    }

    private boolean validarCita(OfimedicCita cita){
        // todo fj2m validar cita
        return true;
    }

    @Override
    public List<OfimedicCita> getCitasProcesadasDesdeFecha(Date desde) {
        return this.dao.getCitasProcesadasDesdeFecha(desde);
    }
}

package com.preving.intranet.restfulapi.model.dao;

import com.preving.intranet.restfulapi.model.domain.OfimedicCita;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by javier-montesinos on 31/05/17.
 */
@Repository
public class OfimedicDaoInMemory implements OfimedicDao {

    private List<OfimedicCita> citas = new ArrayList<>();
    private int contador = 1;

    @Override
    public void save(OfimedicCita cita) {
        System.out.println("Guardando cita" + cita.toString());
        cita.setId(contador);
        citas.add(cita);
        contador++;
    }

    @Override
    public void procesarCitas() {
        for(OfimedicCita cita : citas) {

            if(cita.getProcesadaEstado() == 0) {
                if (cita.getId() % 2 == 0) {
                    cita.setProcesadaEstado(OfimedicCita.ESTADO_PROCESADO_OK);
                    cita.setProcesadaCitaId((int)(Math.random() * 100));
                    cita.setProcesadaFecha(new Date());

                } else if (cita.getId() % 5 == 0) {
                    cita.setProcesadaEstado(OfimedicCita.ESTADO_PROCESADO_ERROR);
                    cita.setProcesadaCitaId(0);
                    cita.setProcesadaError("Aaaaaande vas que te fartan daaaaatos ;)");
                    cita.setProcesadaFecha(new Date());
                }
            }

        }
    }

    @Override
    public List<OfimedicCita> getCitasProcesadasDesdeFecha(Date desde) {
        List<OfimedicCita> citasReturn = new ArrayList<>();

        // Recorre todas las citas y filtra según la fecha desde
        for(OfimedicCita cita : citas) {
            if(cita.getFecha().compareTo(desde) >= 0 && cita.getProcesadaEstado() != 0) {
                citasReturn.add(cita);
            }
        }

        return citasReturn;
    }

}

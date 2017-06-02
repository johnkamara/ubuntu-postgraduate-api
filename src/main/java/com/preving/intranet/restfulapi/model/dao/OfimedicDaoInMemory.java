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

    @Override
    public void save(OfimedicCita cita) {
        System.out.println("Guardando cita" + cita.toString());
        citas.add(cita);
    }

    @Override
    public List<OfimedicCita> getCitasProcesadasDesdeFecha(Date desde) {
        // todo fj2m devolver una lista de citas para procesar

        List<OfimedicCita> citasReturn = new ArrayList<>();

        // Recorre todas las citas y filtra según la fecha desde
        for(OfimedicCita cita : citas) {
            if(cita.getFecha().compareTo(desde) >= 0 ) {
                citasReturn.add(cita);
            }
        }

        return citasReturn;
    }

}

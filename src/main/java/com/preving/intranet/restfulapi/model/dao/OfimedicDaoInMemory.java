package com.preving.intranet.restfulapi.model.dao;

import com.preving.intranet.restfulapi.model.domain.OfimedicCita;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by javier-montesinos on 31/05/17.
 */
@Repository
public class OfimedicDaoInMemory implements OfimedicDao{


    @Override
    public void save(OfimedicCita cita) {
        System.out.println("Guardando cita" + cita.toString());
    }

    @Override
    public List<OfimedicCita> getCitasProcesadasDesdeFecha(Date desde) {
        // todo fj2m devolver una lista de citas para procesar
        return null;
    }
}

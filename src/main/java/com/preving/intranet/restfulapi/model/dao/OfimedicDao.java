package com.preving.intranet.restfulapi.model.dao;

import com.preving.intranet.restfulapi.model.domain.OfimedicCita;

import java.util.Date;
import java.util.List;

/**
 * Created by javier-montesinos on 31/05/17.
 */
public interface OfimedicDao {

    void save(OfimedicCita cita);


    List<OfimedicCita> getCitasProcesadasEntreFichas(Date desde);
}

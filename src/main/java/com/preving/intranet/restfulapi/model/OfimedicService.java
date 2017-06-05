package com.preving.intranet.restfulapi.model;

import com.preving.intranet.restfulapi.model.domain.OfimedicCita;

import java.util.Date;
import java.util.List;

/**
 * Created by javier-montesinos on 31/05/17.
 */
public interface OfimedicService {

    /**
     * ALMACENA LAS CITAS OFRECIDAS SIEMPRE QUE NO EXISTAN PARA EL ORIGEN INDICADO
     * @param citas
     */
    void save(List<OfimedicCita> citas);

    /**
     * Simulamos que Ofimedic procesa las citas que están actualmente enviadas
     */
    void procesarCitas();

    /**
     * Recupera las citas procesadas por ofimedic desde una fecha
     * @param desde
     * @return
     */
    List<OfimedicCita> getCitasProcesadasDesdeFecha(Date desde);
}

package com.preving.intranet.restfulapi.model;

import com.preving.intranet.restfulapi.model.domain.Protocolo;
import com.preving.intranet.restfulapi.model.domain.PuestoTrabajo;

import java.util.List;

/**
 * Created by rogeliogragera on 30/5/17.
 */
public interface ReconocimientosService {

    List<PuestoTrabajo> getPuestosTrabajoByTrabajadorAndCentro(int trabajadorId, int centroId);

    List<Protocolo> getProtocolosAsociadosAPuestoDeTrabajo(int puestoId);
}

package com.preving.intranet.restfulapi.model.dao;

import com.preving.intranet.restfulapi.model.domain.Protocolo;
import com.preving.intranet.restfulapi.model.domain.PuestoTrabajo;

import java.util.List;

/**
 * Created by rogeliogragera on 30/5/17.
 */
public interface ReconocimientosDao {

    List<PuestoTrabajo> getPuestosTrabajoByTrabajadorAndCentro(String trabajadorNif, int centroId);

    List<Protocolo> getProtocolosAsociadosAPuestoDeTrabajo(int puestoId);
}

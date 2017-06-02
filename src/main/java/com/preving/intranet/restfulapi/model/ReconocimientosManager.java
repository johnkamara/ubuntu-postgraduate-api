package com.preving.intranet.restfulapi.model;

import com.preving.intranet.restfulapi.model.dao.ReconocimientosDao;
import com.preving.intranet.restfulapi.model.domain.Protocolo;
import com.preving.intranet.restfulapi.model.domain.PuestoTrabajo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rogeliogragera on 30/5/17.
 */
@Service
public class ReconocimientosManager implements ReconocimientosService {

    @Autowired
    private ReconocimientosDao reconocimientosDao;

    public List<PuestoTrabajo> getPuestosTrabajoByTrabajadorAndCentro(String trabajadorNif, int centroId) {
        return this.reconocimientosDao.getPuestosTrabajoByTrabajadorAndCentro(trabajadorNif, centroId);
    }

    public List<Protocolo> getProtocolosAsociadosAPuestoDeTrabajo(int puestoId) {
        return this.reconocimientosDao.getProtocolosAsociadosAPuestoDeTrabajo(puestoId);
    }
}

package com.preving.intranet.restfulapi.model.dao;

import com.preving.intranet.restfulapi.model.domain.Protocolo;
import com.preving.intranet.restfulapi.model.domain.PuestoTrabajo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rogeliogragera on 30/5/17.
 */
@Repository
public class SpringJdbcReconocimientosDao implements ReconocimientosDao {

    public List<PuestoTrabajo> getPuestosTrabajoByTrabajadorAndCentro(int trabajadorId, int centroId) {
        List<PuestoTrabajo> puestosDeTrabajos = new ArrayList<PuestoTrabajo>();
        if (trabajadorId%2 == 0) {
            puestosDeTrabajos.add(new PuestoTrabajo(1, "Programador", true));
            puestosDeTrabajos.add(new PuestoTrabajo(2, "Analista", false));
            puestosDeTrabajos.add(new PuestoTrabajo(3, "Jefe de Área", true));
        } else {
            puestosDeTrabajos.add(new PuestoTrabajo(4, "Médico", true));
            puestosDeTrabajos.add(new PuestoTrabajo(5, "DUE", false));
            puestosDeTrabajos.add(new PuestoTrabajo(6, "Planificador", true));
        }

        return puestosDeTrabajos;
    }

    public List<Protocolo> getProtocolosAsociadosAPuestoDeTrabajo(int puestoId) {
        List<Protocolo> protocolos = new ArrayList<Protocolo>();
        if (puestoId%2 == 0) {
            protocolos.add(new Protocolo(1, "Reconocimiento Básico"));
            protocolos.add(new Protocolo(2, "Trabajo en altura"));
            protocolos.add(new Protocolo(3, "Plomo"));
        } else {
            protocolos.add(new Protocolo(4, "Trabajo en alta tensión"));
            protocolos.add(new Protocolo(5, "Trabajo en baja tensión"));
            protocolos.add(new Protocolo(6, "Profesor"));
        }

        return protocolos;
    }
}

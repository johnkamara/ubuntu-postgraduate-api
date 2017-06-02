package com.preving.intranet.restfulapi.web;

import com.preving.intranet.restfulapi.model.ReconocimientosService;
import com.preving.intranet.restfulapi.model.domain.Protocolo;
import com.preving.intranet.restfulapi.model.domain.PuestoTrabajo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rogeliogragera on 22/5/17.
 */
@RestController
@RequestMapping(value = "/reconocimientos")
public class ReconocimientosController {

    @Autowired
    private ReconocimientosService reconocimientosService;

    @RequestMapping(value = "puestos-trabajo/{trabajadorNif}/{centroId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<PuestoTrabajo> getPuestosDeTrabajoByTrabajadorAndCentro(
            @PathVariable("trabajadorNif") String trabajadorNif,
            @PathVariable("centroId") int centroId){
        return this.reconocimientosService.getPuestosTrabajoByTrabajadorAndCentro(trabajadorNif, centroId);
    }

    @RequestMapping(value = "protocolos/{puestoId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Protocolo> getProtocolosByPuestoId( @PathVariable("puestoId") int puestoId){
        return this.reconocimientosService.getProtocolosAsociadosAPuestoDeTrabajo(puestoId);
    }
}

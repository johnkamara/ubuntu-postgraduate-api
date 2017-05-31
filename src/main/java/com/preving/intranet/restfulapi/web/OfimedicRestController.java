package com.preving.intranet.restfulapi.web;

import com.preving.intranet.restfulapi.model.OfimedicService;
import com.preving.intranet.restfulapi.model.domain.OfimedicCita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by javier-montesinos on 31/05/17.
 */
@RestController
@RequestMapping(value = "/ofimedic")
public class OfimedicRestController {

    @Autowired
    private OfimedicService service;

    @RequestMapping(value = "/citas", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody void saveCitas(@RequestBody List<OfimedicCita> citas){
        this.service.save(citas);
    }

    @RequestMapping(value = "/citas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<OfimedicCita> getCitasProcesadas(@RequestParam("desde")Date desde){
        return this.service.getCitasProcesadas(desde);
    }
}

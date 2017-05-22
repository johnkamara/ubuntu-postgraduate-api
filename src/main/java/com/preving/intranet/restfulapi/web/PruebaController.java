package com.preving.intranet.restfulapi.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rogeliogragera on 22/5/17.
 */
@RestController
public class PruebaController {

    @RequestMapping(value = "/prueba", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String roge(){
        return "roge";
    }
}

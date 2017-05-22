package com.preving.intranet.restfulapi.web.exceptions;

import com.preving.intranet.restfulapi.model.exceptions.CustomRestApiException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by javier-montesinos on 8/03/17.
 */
@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler({ CustomRestApiException.class})
    public ResponseEntity<Object> handleAll(final CustomRestApiException ex) {
        logger.info(ex.getClass().getName());
        //logger.error("error", ex);

        return new ResponseEntity<Object>(ex.getError(), new HttpHeaders(), ex.getError().getStatus());
    }


}

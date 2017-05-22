package com.preving.intranet.restfulapi.model.exceptions;


import com.preving.intranet.restfulapi.model.exceptions.errors.RestApiErrorCode;
import com.preving.intranet.restfulapi.model.exceptions.errors.RestApiErrorDetail;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * Created by javier-montesinos on 8/03/17.
 */
public class NotFoundRestApiException extends CustomRestApiException {


    public NotFoundRestApiException(RestApiErrorCode code) {
        super(HttpStatus.NOT_FOUND, code);
    }

    public NotFoundRestApiException(RestApiErrorCode code, String customMessage) {
        super(HttpStatus.NOT_FOUND, code, customMessage);
    }

    public NotFoundRestApiException(RestApiErrorCode code, List<RestApiErrorDetail> errorsDetail) {
        super(HttpStatus.NOT_FOUND, code, errorsDetail);
    }

    public NotFoundRestApiException(RestApiErrorCode code, String customMessage, List<RestApiErrorDetail> errorsDetail) {
        super(HttpStatus.NOT_FOUND, code, customMessage, errorsDetail);
    }
}

package com.preving.intranet.restfulapi.model.exceptions.errors;

/**
 * Created by javier-montesinos on 8/03/17.
 */
public class RestApiErrorDetail {

    private String key;
    private String message;

    public RestApiErrorDetail() {
    }

    public RestApiErrorDetail (String message) {
        this(null, message);
    }

    public RestApiErrorDetail(String key, String message) {
        this.key = key;
        this.message = message;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "RestApiErrorDetail{" +
                "key='" + key + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

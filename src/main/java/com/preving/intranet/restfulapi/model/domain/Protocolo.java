package com.preving.intranet.restfulapi.model.domain;

/**
 * Created by rogeliogragera on 30/5/17.
 */
public class Protocolo {

    private int id;
    private String nombre;

    public Protocolo() {
    }

    public Protocolo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

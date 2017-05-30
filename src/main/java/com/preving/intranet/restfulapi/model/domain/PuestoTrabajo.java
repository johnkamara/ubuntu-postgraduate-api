package com.preving.intranet.restfulapi.model.domain;

import java.io.Serializable;

/**
 * Created by rogeliogragera on 30/5/17.
 */
public class PuestoTrabajo implements Serializable {

    private int id;
    private String nombre;
    private boolean seleccionado;

    public PuestoTrabajo() {
    }

    public PuestoTrabajo(int id, String nombre, boolean seleccionado) {
        this.id = id;
        this.nombre = nombre;
        this.seleccionado = seleccionado;
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

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }
}

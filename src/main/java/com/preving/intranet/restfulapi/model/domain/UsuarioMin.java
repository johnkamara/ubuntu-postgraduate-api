package com.preving.intranet.restfulapi.model.domain;

import java.io.Serializable;

/**
 * Created by javier-montesinos on 13/03/17.
 */
public class UsuarioMin implements Serializable {

    private int id;
    private String nombre;
    private String apellidos;
    private String email;
    private String usuario;
    private String movil;

    public UsuarioMin() {
    }

    public UsuarioMin(int id, String nombre, String apellidos, String email, String usuario) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.usuario = usuario;
    }

    public UsuarioMin(int id, String nombre, String apellidos, String email, String usuario, String movil) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.usuario = usuario;
        this.movil = movil;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }
}

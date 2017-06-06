package com.preving.intranet.restfulapi.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by javier-montesinos on 31/05/17.
 */
public class OfimedicCita implements Serializable {

    public static final int ORIGEN_PREVING = 1;
    public static final int ORIGEN_ASEM = 2;

    public static final int ESTADO_PENDIENTE = 0;
    public static final int ESTADO_PROCESADO_OK = 1;
    public static final int ESTADO_PROCESADO_ERROR = -1;

    private int id;
    private int origen;
    private int origenCitaId;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm")
    private Date fecha;

    private String nombre;
    private String apellidos;
    private String nif;
    private String cliente;
    private String medico;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm")
    private Date creado;

    private int procesadaEstado;
    private String procesadaError;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm")
    private Date procesadaFecha;

    private int procesadaCitaId;

    public OfimedicCita() {
    }

    public OfimedicCita(int origen, int origenCitaId, Date fecha, String cliente, String medico) {
        this.origen = origen;
        this.origenCitaId = origenCitaId;
        this.fecha = fecha;
        this.cliente = cliente;
        this.medico = medico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrigen() {
        return origen;
    }

    public void setOrigen(int origen) {
        this.origen = origen;
    }

    public int getOrigenCitaId() {
        return origenCitaId;
    }

    public void setOrigenCitaId(int origenCitaId) {
        this.origenCitaId = origenCitaId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public int getProcesadaEstado() {
        return procesadaEstado;
    }

    public void setProcesadaEstado(int procesadaEstado) {
        this.procesadaEstado = procesadaEstado;
    }

    public String getProcesadaError() {
        return procesadaError;
    }

    public void setProcesadaError(String procesadaError) {
        this.procesadaError = procesadaError;
    }

    public Date getProcesadaFecha() {
        return procesadaFecha;
    }

    public void setProcesadaFecha(Date procesadaFecha) {
        this.procesadaFecha = procesadaFecha;
    }

    public int getProcesadaCitaId() {
        return procesadaCitaId;
    }

    public void setProcesadaCitaId(int procesadaCitaId) {
        this.procesadaCitaId = procesadaCitaId;
    }

    @Override
    public String toString() {
        return "OfimedicCita{" +
                "id=" + id +
                ", origen=" + origen +
                ", origenCitaId=" + origenCitaId +
                ", fecha=" + fecha +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nif='" + nif + '\'' +
                ", cliente='" + cliente + '\'' +
                ", medico='" + medico + '\'' +
                ", creado=" + creado +
                ", procesadaEstado=" + procesadaEstado +
                ", procesadaError='" + procesadaError + '\'' +
                ", procesadaFecha=" + procesadaFecha +
                ", procesadaCitaId=" + procesadaCitaId +
                '}';
    }
}

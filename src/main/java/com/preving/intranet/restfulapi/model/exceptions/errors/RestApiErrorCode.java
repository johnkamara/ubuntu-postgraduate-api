package com.preving.intranet.restfulapi.model.exceptions.errors;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Enumeration of Error or Exception codes.
 *
 * @author Javier Montesinos
 * @since 1.0
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum RestApiErrorCode {
    /**
     * {@code 1001 "Datos del usuario incorrectos. Validacion no aceptada}.
     */
    ERROR_ACCESO_DATOS(1001, "Revise los datos del usuario. Validacion de datos incorrecta"),

    ERROR_VALIDACION_CITAS(2000, "No se ha podido guardar la/s cita/s por errores de validación"),
    ERROR_VALIDACION_CITAS_ORIGEN(2001, "Origen de la cita no válido"),
    ERROR_VALIDACION_CITAS_ORIGENCITAID(2002, "Campo 'origenCitaId' obligatorio"),
    ERROR_VALIDACION_CITAS_FECHA(2003, "Campo 'fecha' obligatorio"),
    ERROR_VALIDACION_CITAS_MEDICO(2004, "Campo 'medico' obligatorio"),
    ERROR_VALIDACION_CITAS_CLIENTE(2005, "Campo 'cliente' obligatorio"),
    ERROR_VALIDACION_CITAS_ESTADO(2006, "La cita debe estar pendiente de procesar"),

    ERROR_CITAS(3000, "Ha ocurrido un error a la hora de guardar la/s cita/s"),

    ;

    private final int value;
    private final String message;

    RestApiErrorCode(int value, String message) {
        this.value = value;
        this.message = message;
    }

    /**
     * Return the integer value of this rest api code.
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Return the message of this rest api code.
     */
    public String getMessage() {
        return this.message;
    }

    public String toString() {
        return Integer.toString(this.value);
    }

    /**
     * Return the enum constant of this type with the specified numeric value.
     * @param codeValue the numeric value of the enum to be returned
     * @return the enum constant with the specified numeric value
     * @throws IllegalArgumentException if this enum has no constant for the specified numeric value
     */
    public static RestApiErrorCode valueOf(int codeValue) {
        for (RestApiErrorCode code : values()) {
            if (code.value == codeValue) {
                return code;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + codeValue + "]");
    }


}

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
    ERROR_ACCESO_DATOS(1001, "Revise los datos del usuario. Validacion de datos incorrecta")


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

package com.tecsup.petclinic.exceptions;

/**
 * Exception for VetSpecialty not found
 */
public class VetSpecialtyNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public VetSpecialtyNotFoundException(String message) {
        super(message);
    }
}
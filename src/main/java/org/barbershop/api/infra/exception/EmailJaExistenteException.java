package org.barbershop.api.infra.exception;

public class EmailJaExistenteException extends RuntimeException {

    public EmailJaExistenteException(String message) {
        super(message);;
    }
}
package org.example.gympro.Exceptions;

public class EmailIllegalException extends Exception {
    public EmailIllegalException() {
        super();
    }
    public EmailIllegalException(String mensaje) {
        super(mensaje);
    }
}

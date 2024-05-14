package org.example.gympro.Exceptions;

public class PostalCodeIllegalException extends Exception {
    public PostalCodeIllegalException() {
        super();
    }
    public PostalCodeIllegalException(String mensaje) {
        super(mensaje);
    }
}

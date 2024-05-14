package org.example.gympro.Exceptions;

public class SuscriptionErrorException extends Exception {
    public SuscriptionErrorException() {
        super();
    }
    public SuscriptionErrorException(String mensaje) {
        super(mensaje);
    }
}

package org.example.gympro.Exceptions;

public class UsernameIllegalException extends Exception {
    public UsernameIllegalException() {
        super();
    }
    public UsernameIllegalException(String mensaje) {
        super(mensaje);
    }
}

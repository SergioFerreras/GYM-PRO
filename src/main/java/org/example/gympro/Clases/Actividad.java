package org.example.gympro.Clases;

import java.time.LocalTime;

public class Actividad {
    private String nombre;
    private String sala;

    public Actividad() {
    }

    public Actividad(String nombre, String sala) {
        setNombre(nombre);
        setSala(sala);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "Actividad{" +
                "nombre='" + nombre + '\'' +
                ", sala='" + sala + '\'' +
                '}';
    }
}

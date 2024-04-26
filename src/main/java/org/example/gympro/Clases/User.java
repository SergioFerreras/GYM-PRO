package org.example.gympro.Clases;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class User {
    private String nombre_usuario;
    private String apellidos_usuario;
    private String email_usuario;
    private int edad_usuario;
    private double peso_usuario;
    private LocalDate fecha_nacimiento_usuario;
    private String direccion_usuario;
    private String codigo_postal_usuario;
    private String telefono_usuario;
    private String dni_usuario;
    private boolean es_hombre;
    private boolean es_administrador;
    private boolean esta_subscrito;
    private String rutina_usuario;
    private String username;
    private String comoNosConoce;
    private String contraseña;

    public User() {
    }

    public User(String username, String nombre, String apellidos, String email, LocalDate fechaNacimiento, double peso, String direccion, String codigoPostal, String telefono, String dni, boolean esHombre, boolean esAdministrador, boolean estaSubscrito, String rutina, String comoNosConoce, String contrasena) {
        setUsername(username);
        setNombre_usuario(nombre);
        setApellidos_usuario(apellidos);
        setEmail_usuario(email);
        setFecha_nacimiento_usuario(fechaNacimiento);
        setPeso_usuario(peso);
        setDireccion_usuario(direccion);
        setCodigo_postal_usuario(codigoPostal);
        setTelefono_usuario(telefono);
        setDni_usuario(dni);
        setEs_hombre(esHombre);
        setEs_administrador(esAdministrador);
        setEsta_subscrito(estaSubscrito);
        setRutina_usuario(rutina);
        setComoNosConoce(comoNosConoce);
        setContraseña(contrasena);
    }
    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellidos_usuario() {
        return apellidos_usuario;
    }

    public void setApellidos_usuario(String apellidos_usuario) {
        this.apellidos_usuario = apellidos_usuario;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public int getEdad_usuario() {
        return edad_usuario;
    }

    public void setEdad_usuario(int edad_usuario) {
        this.edad_usuario = edad_usuario;
    }

    public double getPeso_usuario() {
        return peso_usuario;
    }

    public void setPeso_usuario(double peso_usuario) {
        this.peso_usuario = peso_usuario;
    }

    public LocalDate getFecha_nacimiento_usuario() {
        return fecha_nacimiento_usuario;
    }

    public void setFecha_nacimiento_usuario(LocalDate fecha_nacimiento_usuario) {
        this.fecha_nacimiento_usuario = fecha_nacimiento_usuario;
    }

    public String getDireccion_usuario() {
        return direccion_usuario;
    }

    public void setDireccion_usuario(String direccion_usuario) {
        this.direccion_usuario = direccion_usuario;
    }

    public String getCodigo_postal_usuario() {
        return codigo_postal_usuario;
    }

    public void setCodigo_postal_usuario(String codigo_postal_usuario) {
        this.codigo_postal_usuario = codigo_postal_usuario;
    }

    public String getTelefono_usuario() {
        return telefono_usuario;
    }

    public void setTelefono_usuario(String telefono_usuario) {
        this.telefono_usuario = telefono_usuario;
    }

    public String getDni_usuario() {
        return dni_usuario;
    }

    public void setDni_usuario(String dni_usuario) {
        this.dni_usuario = dni_usuario;
    }

    public boolean isEs_hombre() {
        return es_hombre;
    }

    public void setEs_hombre(boolean es_hombre) {
        this.es_hombre = es_hombre;
    }

    public boolean isEs_administrador() {
        return es_administrador;
    }

    public void setEs_administrador(boolean es_administrador) {
        this.es_administrador = es_administrador;
    }

    public boolean isEsta_subscrito() {
        return esta_subscrito;
    }

    public void setEsta_subscrito(boolean esta_subscrito) {
        this.esta_subscrito = esta_subscrito;
    }

    public String getRutina_usuario() {
        return rutina_usuario;
    }

    public void setRutina_usuario(String rutina_usuario) {
        this.rutina_usuario = rutina_usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComoNosConoce() {
        return comoNosConoce;
    }

    public void setComoNosConoce(String comoNosConoce) {
        this.comoNosConoce = comoNosConoce;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "User{" +
                "nombre_usuario='" + nombre_usuario + '\'' +
                ", apellidos_usuario='" + apellidos_usuario + '\'' +
                ", email_usuario='" + email_usuario + '\'' +
                ", edad_usuario=" + edad_usuario +
                ", peso_usuario=" + peso_usuario +
                ", fecha_nacimiento_usuario=" + fecha_nacimiento_usuario +
                ", direccion_usuario='" + direccion_usuario + '\'' +
                ", codigo_postal_usuario='" + codigo_postal_usuario + '\'' +
                ", telefono_usuario='" + telefono_usuario + '\'' +
                ", dni_usuario='" + dni_usuario + '\'' +
                ", es_hombre=" + es_hombre +
                ", es_administrador=" + es_administrador +
                ", esta_subscrito=" + esta_subscrito +
                ", rutina_usuario='" + rutina_usuario + '\'' +
                ", username='" + username + '\'' +
                ", comoNosConoce='" + comoNosConoce + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }
}

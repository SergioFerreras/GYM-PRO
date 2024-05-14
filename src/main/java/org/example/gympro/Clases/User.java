package org.example.gympro.Clases;

import javafx.geometry.Pos;
import org.example.gympro.Database.DataBaseController;
import org.example.gympro.DateController.DateController;
import org.example.gympro.Exceptions.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class User {
    int id_usuario;
    String nombre_usuario;
    String apellidos_usuario;
    String email_usuario;
    Double peso_usuario;
    Date fecha_nacimiento_usuario;
    String direccion_usuario;
    String codigo_postal_usuario;
    String telefono_usuario;
    String dni_usuario;
    Boolean es_hombre;
    String username;
    String comoNosConoce;
    String contrasena;
    int edad_usuario;
    Boolean suscrito;

    public User() {
    }

    public User(int id_usuario, String nombre_usuario, String apellidos_usuario, String email_usuario, Double peso_usuario, Date fecha_nacimiento_usuario, String direccion_usuario, String codigo_postal_usuario, String telefono_usuario, String dni_usuario, Boolean es_hombre, String username, String comoNosConoce, String contrasena) throws Exception{
        setId_usuario(id_usuario);
        setNombre_usuario(nombre_usuario);
        setApellidos_usuario(apellidos_usuario);
        setEmail_usuario(email_usuario);
        setPeso_usuario(peso_usuario);
        setFecha_nacimiento_usuario(fecha_nacimiento_usuario);
        setDireccion_usuario(direccion_usuario);
        setCodigo_postal_usuario(codigo_postal_usuario);
        setTelefono_usuario(telefono_usuario);
        setDni_usuario(dni_usuario);
        setEs_hombre(es_hombre);
        setUsername(username);
        setComoNosConoce(comoNosConoce);
        setContrasena(contrasena);
        setEdad_usuario(fecha_nacimiento_usuario);
        setSuscrito();
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) throws NameIllegalException{
        if (nombre_usuario.matches("[a-zA-Z]+")) {
            this.nombre_usuario = nombre_usuario;
        } else {
            throw new NameIllegalException("El nombre no puede contener numeros");
        }
    }


    public String getApellidos_usuario() {
        return apellidos_usuario;
    }

    public void setApellidos_usuario(String apellidos_usuario) throws SurnameIllegalException {
        if (apellidos_usuario.matches("[a-zA-Z\\s]+")) {
            this.apellidos_usuario = apellidos_usuario;
        } else {
            throw new SurnameIllegalException("El apellido no puede contener números ni caracteres especiales");
        }
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) throws EmailIllegalException {
        String regex = "^(.+)@(.+)$";

        if (email_usuario.matches(regex)) {
            this.email_usuario = email_usuario;
        } else {
            throw new EmailIllegalException("El correo electrónico tiene un formato inválido.");
        }
    }


    public int getEdad_usuario() {
        return edad_usuario;
    }

    public void setEdad_usuario(Date fechaNacimiento) {
        if (fechaNacimiento==null){
            this.edad_usuario= 0;
        }else {
            DateController dc=new DateController();
            Date fechaActual = dc.getFechaActual();

            long diferenciaEnMs = fechaActual.getTime() - fechaNacimiento.getTime();

            long años = diferenciaEnMs / 1000 / 60 / 60 / 24 / 365;

            this.edad_usuario=(int) años;
        }
    }

    public double getPeso_usuario() {
        return peso_usuario;
    }

    public void setPeso_usuario(double peso_usuario) throws WeightIllegalException{
        String pesoStr = String.valueOf(peso_usuario);

        String regex = "^\\d+(\\.\\d{1,2})?$";

        if (pesoStr.matches(regex)) {
            this.peso_usuario = peso_usuario;
        } else {
          throw new WeightIllegalException("El peso tiene un formato inválido, puede tener uno o dos decimales");
        }
    }

    public String getDireccion_usuario() {
        return direccion_usuario;
    }

    public void setDireccion_usuario(String direccion_usuario) {
        if (direccion_usuario==null){
            throw new NullPointerException("La direccion no puede estar vacia");
        }else {
            this.direccion_usuario = direccion_usuario;
        }

    }

    public String getCodigo_postal_usuario() {
        return codigo_postal_usuario;
    }

    public void setCodigo_postal_usuario(String codigo_postal_usuario) throws PostalCodeIllegalException {
        String regex = "^\\d{5}$";

        if (codigo_postal_usuario.matches(regex)) {
            this.codigo_postal_usuario = codigo_postal_usuario;
        } else {
            throw new PostalCodeIllegalException("El código postal tiene un formato inválido tiene que tener 5 dijitos.");
        }
    }

    public String getTelefono_usuario() {
        return telefono_usuario;
    }

    public void setTelefono_usuario(String telefono_usuario) throws TelephoneIllegalException{
         String regex = "^\\d{9}$";

        if (telefono_usuario.matches(regex)) {
            this.telefono_usuario = telefono_usuario;
        } else {
             System.out.println("El número de teléfono tiene un formato inválido. Debe contener exactamente 9 dígitos numéricos.");
             throw new TelephoneIllegalException("El número de teléfono tiene un formato inválido, tiene que tener 9 numeros.");
        }
    }


    public String getDni_usuario() {
        return dni_usuario;
    }

    public void setDni_usuario(String dni_usuario) throws DNIIllegalException {
        String regex = "^\\d{8}[A-Za-z]$";

        if (dni_usuario.matches(regex)) {
            this.dni_usuario = dni_usuario.toUpperCase();
        } else {
            throw new DNIIllegalException("El DNI tiene un formato inválido, tiene que tener 8 numeros y una letra.");
        }
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username==null){
            throw new NullPointerException("El campo username tiene que ser relleno");
        }else {
            this.username = username;
        }
    }

    public String getComoNosConoce() {
        return comoNosConoce;
    }

    public void setComoNosConoce(String comoNosConoce) {
            this.comoNosConoce = comoNosConoce;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }


    public void setFecha_nacimiento_usuario(Date fecha_nacimiento_usuario) throws AGEIllegalException{
        DateController dc=new DateController();
        Date fechaActual = dc.getFechaActual();

        long diferenciaEnMs = fechaActual.getTime() - fecha_nacimiento_usuario.getTime();

        long años = diferenciaEnMs / 1000 / 60 / 60 / 24 / 365;

        int nalos=(int) años;

        if (años>=18){
            this.fecha_nacimiento_usuario = fecha_nacimiento_usuario;
        } else {
            throw new AGEIllegalException("Debes de ser mayor de 18 años");
        }


    }

    public Date getFecha_nacimiento_usuario() {
        return fecha_nacimiento_usuario;
    }

    public Boolean is_hombre() {
        return es_hombre;
    }

    public void setEs_hombre(Boolean es_hombre) {
            this.es_hombre = es_hombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        if (contrasena==null){
            throw new NullPointerException("La contraseña no puede ser nula");
        }else{
            this.contrasena = contrasena;
        }
    }

    public String GenereToString(){
        boolean genre=is_hombre();
        if (genre){
            return "Male";
        }else{
            return "Famale";
        }
    }

    public Boolean getSuscrito() {
        return suscrito;
    }

    public void setSuscrito() {
        DataBaseController dbc=new DataBaseController();
        DateController dc=new DateController();

        Date fechaFin=dbc.cogerFechaFinSuscripcion(getUsername());
        Date fechaActual=dc.getFechaActual();

        if (fechaFin == null) {
            this.suscrito = false;
        } else if (fechaFin != null && fechaFin.before(fechaActual)) {
            this.suscrito = false;
        } else {
            this.suscrito = true;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id_usuario=" + id_usuario +
                ", nombre_usuario='" + nombre_usuario + '\'' +
                ", apellidos_usuario='" + apellidos_usuario + '\'' +
                ", email_usuario='" + email_usuario + '\'' +
                ", peso_usuario=" + peso_usuario +
                ", fecha_nacimiento_usuario=" + fecha_nacimiento_usuario +
                ", direccion_usuario='" + direccion_usuario + '\'' +
                ", codigo_postal_usuario='" + codigo_postal_usuario + '\'' +
                ", telefono_usuario='" + telefono_usuario + '\'' +
                ", dni_usuario='" + dni_usuario + '\'' +
                ", es_hombre=" + es_hombre +
                ", username='" + username + '\'' +
                ", comoNosConoce='" + comoNosConoce + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", edad_usuario=" + edad_usuario +
                ", suscrito=" + suscrito +
                '}';
    }
}

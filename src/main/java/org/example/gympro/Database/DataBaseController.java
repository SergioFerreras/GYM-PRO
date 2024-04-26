package org.example.gympro.Database;

import org.example.gympro.Clases.User;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DataBaseController {

    private static String urlDB = "jdbc:mysql://192.168.56.101:3306/GYM_PRO";
    private static String user = "admin00";
    private static String password = "alumno";

    public static String getUrlDB() {
        return urlDB;
    }

    public static void setUrlDB(String urlDB) {
        DataBaseController.urlDB = urlDB;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        DataBaseController.user = user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        DataBaseController.password = password;
    }

    public DataBaseController() {
    }

    public static User seleccionarUserCompleto(String nombreUsuario) {
        String urlDB = getUrlDB();
        String user = getUser();
        String password = getPassword();

        User user1 = null;

        try (Connection connection = DriverManager.getConnection(urlDB, user, password)) {

            String consulta = "SELECT u.username, u.nombre_usuario, u.apellidos_usuario, u.email_usuario, u.fecha_nacimiento_usuario, " +
                    "u.peso_usuario, u.direccion_usuario, u.codigo_postal_usuario, u.telefono_usuario, u.dni_usuario, " +
                    "u.es_hombre, u.es_administrador, u.esta_subscrito, u.rutina_usuario, u.comoNosConoce, c.contrasena " +
                    "FROM Usuario u " +
                    "JOIN Contrasena c ON u.username = c.username " +
                    "WHERE u.username = ?";

            try (PreparedStatement statement = connection.prepareStatement(consulta)) {

                statement.setString(1, nombreUsuario);

                try (ResultSet rs = statement.executeQuery()) {
                    if (rs.next()) {
                        String username = rs.getString("username");
                        String nombre = rs.getString("nombre_usuario");
                        String apellidos = rs.getString("apellidos_usuario");
                        String email = rs.getString("email_usuario");
                        LocalDate fechaNacimiento = rs.getDate("fecha_nacimiento_usuario").toLocalDate();
                        double peso = rs.getDouble("peso_usuario");
                        String direccion = rs.getString("direccion_usuario");
                        String codigoPostal = rs.getString("codigo_postal_usuario");
                        String telefono = rs.getString("telefono_usuario");
                        String dni = rs.getString("dni_usuario");
                        boolean esHombre = rs.getBoolean("es_hombre");
                        boolean esAdministrador = rs.getBoolean("es_administrador");
                        boolean estaSubscrito = rs.getBoolean("esta_subscrito");
                        String rutina = rs.getString("rutina_usuario");
                        String comoNosConoce = rs.getString("comoNosConoce");
                        String contrasena = rs.getString("contrasena");

                        user1 = new User(username, nombre, apellidos, email, fechaNacimiento, peso, direccion, codigoPostal, telefono, dni, esHombre, esAdministrador, estaSubscrito, rutina, comoNosConoce, contrasena);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        return user1;
    }


    public static void main(String[]args) {
        seleccionarUserCompleto("juanperez");
    }


}

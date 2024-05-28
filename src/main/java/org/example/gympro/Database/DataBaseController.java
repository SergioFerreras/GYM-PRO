package org.example.gympro.Database;

import org.example.gympro.Clases.Rutina;
import org.example.gympro.Clases.User;
import org.example.gympro.Exceptions.SuscriptionErrorException;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class DataBaseController {

    private static String urlDB = "jdbc:mysql://192.168.56.101:3306/GYM_PRO_2_0";
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

            String consulta = "SELECT u.id_usuario, u.nombre_usuario, u.apellidos_usuario, u.email_usuario, u.peso_usuario, u.fecha_nacimiento_usuario, u.direccion_usuario, u.codigo_postal_usuario, u.telefono_usuario, u.dni_usuario, u.es_hombre, u.username, u.comoNosConoce, c.contrasena FROM Usuario u INNER JOIN Contrasena c ON u.id_usuario = c.id_usuario WHERE u.username=?;";

            try (PreparedStatement statement = connection.prepareStatement(consulta)) {

                statement.setString(1, nombreUsuario);

                try (ResultSet rs = statement.executeQuery()) {
                    if (rs.next()) {

                        int id_usuario=rs.getInt("id_usuario");
                        String nombre_usuario=rs.getString("nombre_usuario");
                        String apellidos_usuario=rs.getString("apellidos_usuario");
                        String email_usuario=rs.getString("email_usuario");
                        Double peso_usuario=rs.getDouble("peso_usuario");
                        Date fecha_nacimiento_usuario=rs.getDate("fecha_nacimiento_usuario");
                        String direccion_usuario=rs.getString("direccion_usuario");
                        String codigo_postal_usuario=rs.getString("codigo_postal_usuario");
                        String telefono_usuario=rs.getString("telefono_usuario");
                        String dni_usuario=rs.getString("dni_usuario");
                        Boolean es_hombre=rs.getBoolean("es_hombre");
                        String username=rs.getString("username");
                        String comoNosConoce=rs.getString("comoNosConoce");
                        String contrasena=rs.getString("contrasena");

                        user1 = new User(id_usuario,nombre_usuario,apellidos_usuario,email_usuario,peso_usuario,fecha_nacimiento_usuario,direccion_usuario,codigo_postal_usuario,telefono_usuario,dni_usuario,es_hombre,username,comoNosConoce,contrasena);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        return user1;
    }

        public Rutina obtenerRutinasUsuario(String nombreUsuario) {
        Rutina rutina=null;

        try (Connection connection = DriverManager.getConnection(urlDB, user, password)) {
            String consulta = "SELECT r.ID, r.NombreRutina,r.DescripcionRutina FROM Usuario u JOIN Usuarios_Rutinas ur ON u.id_usuario = ur.IDUsuario JOIN Rutinas r ON ur.IDRutina = r.ID WHERE u.username = ?";

            try (PreparedStatement statement = connection.prepareStatement(consulta)) {
                statement.setString(1, nombreUsuario);

                try (ResultSet rs = statement.executeQuery()) {
                    while (rs.next()) {
                        int id = rs.getInt("ID");
                        String nombreRutina = rs.getString("NombreRutina");
                        String descripcionRutina = rs.getString("DescripcionRutina");

                        rutina = new Rutina(id, nombreRutina, descripcionRutina);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rutina;
    }

    public void asignarOActualizarRutina(String nombreUsuario, String nombreNuevaRutina) {
        try (Connection connection = DriverManager.getConnection(urlDB, user, password)) {
            String consultaExisteRutina = "SELECT COUNT(*) AS total FROM Usuario u JOIN Usuarios_Rutinas ur ON u.id_usuario = ur.IDUsuario WHERE u.username = ?";
            try (PreparedStatement statementExisteRutina = connection.prepareStatement(consultaExisteRutina)) {
                statementExisteRutina.setString(1, nombreUsuario);
                try (ResultSet rsExisteRutina = statementExisteRutina.executeQuery()) {
                    rsExisteRutina.next();
                    int totalRutinas = rsExisteRutina.getInt("total");

                    if (totalRutinas == 0) {
                        String consultaInsertarRutina = "INSERT INTO Usuarios_Rutinas (IDUsuario, IDRutina) SELECT id_usuario, ID FROM Usuario, Rutinas WHERE username = ? AND NombreRutina = ?";
                        try (PreparedStatement statementInsertarRutina = connection.prepareStatement(consultaInsertarRutina)) {
                            statementInsertarRutina.setString(1, nombreUsuario);
                            statementInsertarRutina.setString(2, nombreNuevaRutina);
                            statementInsertarRutina.executeUpdate();
                            System.out.println("No tiene rutina, se ha insertado una nueva.");
                        }
                    } else {
                        String consultaActualizarRutina = "UPDATE Usuarios_Rutinas ur JOIN Usuario u ON ur.IDUsuario = u.id_usuario JOIN Rutinas r ON r.NombreRutina = ? SET ur.IDRutina = r.ID WHERE u.username = ?";
                        try (PreparedStatement statementActualizarRutina = connection.prepareStatement(consultaActualizarRutina)) {
                            statementActualizarRutina.setString(1, nombreNuevaRutina);
                            statementActualizarRutina.setString(2, nombreUsuario);
                            statementActualizarRutina.executeUpdate();
                            System.out.println("Ya tiene rutina, se ha actualizado.");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static boolean insertarNuevoUsuario(User usuario) {
        String urlDB = getUrlDB();
        String user = getUser();
        String password = getPassword();

        boolean exito = false;

        try (Connection connection = DriverManager.getConnection(urlDB, user, password)) {

            String insercionUsuario = "INSERT INTO Usuario (nombre_usuario, apellidos_usuario, email_usuario, peso_usuario, fecha_nacimiento_usuario, direccion_usuario, codigo_postal_usuario, telefono_usuario, dni_usuario, es_hombre, username, comoNosConoce) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(insercionUsuario, Statement.RETURN_GENERATED_KEYS)) {

                statement.setString(1, usuario.getNombre_usuario());
                statement.setString(2, usuario.getApellidos_usuario());
                statement.setString(3, usuario.getEmail_usuario());
                statement.setDouble(4, usuario.getPeso_usuario());
                statement.setDate(5, usuario.getFecha_nacimiento_usuario());
                statement.setString(6, usuario.getDireccion_usuario());
                statement.setString(7, usuario.getCodigo_postal_usuario());
                statement.setString(8, usuario.getTelefono_usuario());
                statement.setString(9, usuario.getDni_usuario());
                statement.setBoolean(10, usuario.is_hombre());
                statement.setString(11, usuario.getUsername());
                statement.setString(12, usuario.getComoNosConoce());

                int filasAfectadas = statement.executeUpdate();

                if (filasAfectadas > 0) {
                    try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            int idUsuarioGenerado = generatedKeys.getInt(1);
                            usuario.setId_usuario(idUsuarioGenerado);
                            exito = true;
                        }
                    }
                }
            }

            if (exito) {
                String insercionContrasena = "INSERT INTO Contrasena (id_usuario, contrasena) VALUES (?, ?)";

                try (PreparedStatement statement = connection.prepareStatement(insercionContrasena)) {
                    statement.setInt(1, usuario.getId_usuario());
                    statement.setString(2, usuario.getContrasena());

                    int filasAfectadas = statement.executeUpdate();

                    if (filasAfectadas <= 0) {
                        exito = false;
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar nuevo usuario: " + e.getMessage());
        }

        return exito;
    }



    public  boolean existeUsername(String username) {
        return existeUsuarioPorCampo("username", username);
    }

    public  boolean existeEmail(String emailUsuario) {
        return existeUsuarioPorCampo("email_usuario", emailUsuario);
    }

    public  boolean existeTelefono(String telefonoUsuario) {
        return existeUsuarioPorCampo("telefono_usuario", telefonoUsuario);
    }

    public  boolean existeDNI(String dniUsuario) {
        return existeUsuarioPorCampo("dni_usuario", dniUsuario);
    }

    private  boolean existeUsuarioPorCampo(String campo, String valor) {
        String urlDB = getUrlDB();
        String user = getUser();
        String password = getPassword();

        boolean existe = false;

        try (Connection connection = DriverManager.getConnection(urlDB, user, password)) {

            String consulta = "SELECT COUNT(*) AS existe FROM Usuario WHERE " + campo + " = ?";

            try (PreparedStatement statement = connection.prepareStatement(consulta)) {

                statement.setString(1, valor);

                try (ResultSet rs = statement.executeQuery()) {
                    if (rs.next()) {
                        int cantidad = rs.getInt("existe");
                        existe = cantidad > 0;
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }

        return existe;
    }

    public static Date cogerFechaFinSuscripcion(String nombreUsuario) {
        String urlDB = getUrlDB();
        String user = getUser();
        String password = getPassword();

        Date Fecha = null;

        try (Connection connection = DriverManager.getConnection(urlDB, user, password)) {

            String consulta = "SELECT fecha_fin FROM suscripciones WHERE usuario_id = (SELECT id_usuario FROM Usuario WHERE username = ?);";
            try (PreparedStatement statement = connection.prepareStatement(consulta)) {
                statement.setString(1, nombreUsuario);
                try (ResultSet rs = statement.executeQuery()) {
                    if (rs.next()) {
                        Fecha=rs.getDate("fecha_fin");
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        return Fecha;
    }

    public static String cogerNombreSuscripcion(String nombreUsuario) {
        String urlDB = getUrlDB();
        String user = getUser();
        String password = getPassword();

        String Plan = null;

        try (Connection connection = DriverManager.getConnection(urlDB, user, password)) {

            String consulta = "SELECT plan FROM suscripciones WHERE usuario_id = (SELECT id_usuario FROM Usuario WHERE username = ?);";
            try (PreparedStatement statement = connection.prepareStatement(consulta)) {
                statement.setString(1, nombreUsuario);
                try (ResultSet rs = statement.executeQuery()) {
                    if (rs.next()) {
                        Plan=rs.getString("plan");
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        return Plan;
    }

    public static void actualizarSuscripcion(String username, String nuevoPlan, String nuevaFechaInicio, String nuevaFechaFin) throws SuscriptionErrorException {
        String urlDB = getUrlDB();
        String user = getUser();
        String password = getPassword();

        try (Connection connection = DriverManager.getConnection(urlDB, user, password)) {

            boolean usuarioTieneSuscripcion = usuarioTieneSuscripcion(connection, username);

            if (usuarioTieneSuscripcion) {
                String consultaActualizar = "UPDATE suscripciones s INNER JOIN Usuario u ON s.usuario_id = u.id_usuario SET s.fecha_inicio=?, s.fecha_fin=?, s.plan=? WHERE u.username=?";
                try (PreparedStatement statementActualizar = connection.prepareStatement(consultaActualizar)) {
                    statementActualizar.setString(1, nuevaFechaInicio);
                    statementActualizar.setString(2, nuevaFechaFin);
                    statementActualizar.setString(3, nuevoPlan);
                    statementActualizar.setString(4, username);

                    int filasActualizadas = statementActualizar.executeUpdate();
                    if (filasActualizadas > 0) {
                        System.out.println("Suscripción actualizada correctamente.");
                    } else {
                        throw new SuscriptionErrorException("No se ha podido actualizar la suscripción");
                    }
                }
            } else {
                crearNuevaSuscripcion(connection, username, nuevoPlan, nuevaFechaInicio, nuevaFechaFin);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static boolean usuarioTieneSuscripcion(Connection connection, String username) throws SQLException {
        String consultaUsuario = "SELECT COUNT(*) AS count FROM suscripciones s INNER JOIN Usuario u ON s.usuario_id = u.id_usuario WHERE u.username=?";
        try (PreparedStatement statementUsuario = connection.prepareStatement(consultaUsuario)) {
            statementUsuario.setString(1, username);
            try (ResultSet resultSet = statementUsuario.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt("count");
                    return count > 0;
                }
            }
        }
        return false;
    }

    private static void crearNuevaSuscripcion(Connection connection, String username, String nuevoPlan, String nuevaFechaInicio, String nuevaFechaFin) throws SQLException, SuscriptionErrorException {
        String consultaCrear = "INSERT INTO suscripciones (usuario_id, plan, fecha_inicio, fecha_fin) SELECT id_usuario, ?, ?, ? FROM Usuario WHERE username=?";
        try (PreparedStatement statementCrear = connection.prepareStatement(consultaCrear)) {
            statementCrear.setString(1, nuevoPlan);
            statementCrear.setString(2, nuevaFechaInicio);
            statementCrear.setString(3, nuevaFechaFin);
            statementCrear.setString(4, username);

            int filasInsertadas = statementCrear.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Nueva suscripción creada correctamente.");
            } else {
                throw new SuscriptionErrorException("No se ha podido crear la nueva suscripción");
            }
        }
    }


    public void reserveActivity(String username, String activityName, String roomName, String bodyPart) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(getUrlDB(), getUser(), getPassword());

            // Obtener id_usuario
            String sqlGetUserId = "SELECT id_usuario FROM Usuario WHERE username = ?";
            pstmt = conn.prepareStatement(sqlGetUserId);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();

            if (!rs.next()) {
                System.out.println("Usuario no encontrado.");
                return;
            }

            int userId = rs.getInt("id_usuario");
            rs.close();
            pstmt.close();

            // Obtener id_actividad
            String sqlGetActivityId = "SELECT id_actividad FROM Actividades WHERE nombre = ?";
            pstmt = conn.prepareStatement(sqlGetActivityId);
            pstmt.setString(1, activityName);
            rs = pstmt.executeQuery();

            if (!rs.next()) {
                System.out.println("Actividad no encontrada.");
                return;
            }

            int activityId = rs.getInt("id_actividad");
            rs.close();
            pstmt.close();

            // Obtener id_sala
            String sqlGetRoomId = "SELECT id_sala FROM Salas WHERE nombre = ?";
            pstmt = conn.prepareStatement(sqlGetRoomId);
            pstmt.setString(1, roomName);
            rs = pstmt.executeQuery();

            if (!rs.next()) {
                System.out.println("Sala no encontrada.");
                return;
            }

            int roomId = rs.getInt("id_sala");
            rs.close();
            pstmt.close();

            // Verificar participantes en la sala y actividad
            String sqlCheckParticipants = "SELECT participantes_" + bodyPart.toLowerCase() + " FROM SalaActividad WHERE id_sala = ? AND id_actividad = ?";
            pstmt = conn.prepareStatement(sqlCheckParticipants);
            pstmt.setInt(1, roomId);
            pstmt.setInt(2, activityId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                int participants = rs.getInt("participantes_" + bodyPart.toLowerCase());
                if (participants >= 15) {  // Cambio a 15, según lo solicitado
                    System.out.println("La sala está llena para esa actividad y ese músculo.");
                    return;
                }
            }
            rs.close();
            pstmt.close();

            // Iniciar transacción
            conn.setAutoCommit(false);

            // Eliminar todas las reservas anteriores del usuario y actualizar los participantes
            String sqlGetExistingReservations = "SELECT id_reserva, parte_cuerpo, id_actividad, id_sala FROM Reservas WHERE id_usuario = ?";
            pstmt = conn.prepareStatement(sqlGetExistingReservations);
            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int previousReservationId = rs.getInt("id_reserva");
                String previousBodyPart = rs.getString("parte_cuerpo");
                int previousActivityId = rs.getInt("id_actividad");
                int previousRoomId = rs.getInt("id_sala");

                // Eliminar reserva anterior
                String sqlDeleteReservation = "DELETE FROM Reservas WHERE id_reserva = ?";
                PreparedStatement pstmtDelete = conn.prepareStatement(sqlDeleteReservation);
                pstmtDelete.setInt(1, previousReservationId);
                pstmtDelete.executeUpdate();
                pstmtDelete.close();

                // Actualizar contadores de participantes de la actividad anterior
                String sqlUpdatePreviousParticipants = "UPDATE SalaActividad SET participantes_" + previousBodyPart.toLowerCase() + " = participantes_" + previousBodyPart.toLowerCase() + " - 1 WHERE id_sala = ? AND id_actividad = ?";
                PreparedStatement pstmtUpdate = conn.prepareStatement(sqlUpdatePreviousParticipants);
                pstmtUpdate.setInt(1, previousRoomId);
                pstmtUpdate.setInt(2, previousActivityId);
                pstmtUpdate.executeUpdate();
                pstmtUpdate.close();
            }
            rs.close();
            pstmt.close();

            // Insertar nueva reserva
            String sqlInsertReservation = "INSERT INTO Reservas (id_usuario, id_actividad, id_sala, parte_cuerpo) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sqlInsertReservation);
            pstmt.setInt(1, userId);
            pstmt.setInt(2, activityId);
            pstmt.setInt(3, roomId);
            pstmt.setString(4, bodyPart);
            int rowsInserted = pstmt.executeUpdate();
            pstmt.close();

            if (rowsInserted > 0) {
                System.out.println("Reserva realizada con éxito.");

                String sqlUpdateParticipants = "UPDATE SalaActividad SET participantes_" + bodyPart.toLowerCase() + " = participantes_" + bodyPart.toLowerCase() + " + 1 WHERE id_sala = ? AND id_actividad = ?";
                pstmt = conn.prepareStatement(sqlUpdateParticipants);
                pstmt.setInt(1, roomId);
                pstmt.setInt(2, activityId);
                pstmt.executeUpdate();
                pstmt.close();

                // Confirmar transacción
                conn.commit();
            } else {
                System.out.println("Error al realizar la reserva.");
                conn.rollback();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            if (conn != null) {
                conn.rollback();
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    }


    public static boolean checkAvailability(String username, String activityName, String bodyPart) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(getUrlDB(), getUser(), getPassword());

            String sqlGetUserId = "SELECT id_usuario FROM Usuario WHERE username = ?";
            pstmt = conn.prepareStatement(sqlGetUserId);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();

            if (!rs.next()) {
                System.out.println("Usuario no encontrado.");
                return false;
            }

            int userId = rs.getInt("id_usuario");
            rs.close();
            pstmt.close();

            String sqlGetActivityId = "SELECT id_actividad FROM Actividades WHERE nombre = ?";
            pstmt = conn.prepareStatement(sqlGetActivityId);
            pstmt.setString(1, activityName);
            rs = pstmt.executeQuery();

            if (!rs.next()) {
                System.out.println("Actividad no encontrada.");
                return false;
            }

            int activityId = rs.getInt("id_actividad");
            rs.close();
            pstmt.close();

            return isActivityForMuscle(conn, activityId, bodyPart);

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean isActivityForMuscle(Connection conn, int activityId, String bodyPart) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sqlCheckMuscle = "SELECT id_actividad FROM SalaActividad WHERE id_actividad = ? AND participantes_" + bodyPart.toLowerCase() + " < 15";
        pstmt = conn.prepareStatement(sqlCheckMuscle);
        pstmt.setInt(1, activityId);
        rs = pstmt.executeQuery();

        boolean available = rs.next();
        rs.close();
        pstmt.close();

        return available;
    }

    public String getReservedActivityByUsername(String username) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Establecer la conexión con la base de datos
            conn = DriverManager.getConnection(getUrlDB(), getUser(), getPassword());

            // Obtener el ID del usuario a partir del nombre de usuario
            String sqlGetUserId = "SELECT id_usuario FROM Usuario WHERE username = ?";
            pstmt = conn.prepareStatement(sqlGetUserId);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();

            if (!rs.next()) {
                System.out.println("Usuario no encontrado.");
                return null;
            }

            int userId = rs.getInt("id_usuario");
            rs.close();
            pstmt.close();

            // Obtener el nombre de la actividad reservada por el usuario
            String sqlGetActivityName = "SELECT a.nombre FROM Reservas r " +
                    "JOIN Actividades a ON r.id_actividad = a.id_actividad " +
                    "WHERE r.id_usuario = ?";
            pstmt = conn.prepareStatement(sqlGetActivityName);
            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getString("nombre");
            } else {
                System.out.println("No hay reservas para este usuario.");
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    public static void main(String[]args) {
        DataBaseController dbc=new DataBaseController();
        String n=dbc.getReservedActivityByUsername("sergio");
        System.out.println(n);
    }


}

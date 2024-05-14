package org.example.gympro.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.gympro.Clases.User;
import org.example.gympro.Database.DataBaseController;
import org.example.gympro.DateController.DateController;

import java.sql.Date;

public class UserSignUpController {
    private User user;
    @FXML
    private TextField usernameTF;
    @FXML
    private TextField nameTF;
    @FXML
    private TextField surnameTF;
    @FXML
    private TextField passwordTF;
    @FXML
    private TextField cpasswordTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField telphonenTF;
    @FXML
    private TextField adressTF;
    @FXML
    private TextField pcodeTF;
    @FXML
    private TextField dniTF;
    @FXML
    private DatePicker birthTF;

    @FXML
    private Button continueButton;

    @FXML
    private Button loginButton;

    @FXML
    private Button crossButton;

    @FXML
    private void irLogin(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/UserLogin.fxml"));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            Stage escenarioActual = (Stage) loginButton.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println("Error: "+e.getMessage());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void cerrarVentana(ActionEvent event) {
        Stage stage = (Stage) crossButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void continuar(){
        DataBaseController dbc= new DataBaseController();

        if (algunovacio()){
            showPopUpWindow("Rellena todos los campos para continuar");
        }else{
            if (!passwordTF.getText().equals(cpasswordTF.getText())){
                showPopUpWindow("La contraseña no esta confirmada");
            }else {
                if (dbc.existeUsername(usernameTF.getText())){
                    showPopUpWindow("El nombre de usuario ya esta usado");
                } else if (dbc.existeEmail(emailTF.getText())) {
                    showPopUpWindow("Este email esta usado en otra cuenta");
                }else if (dbc.existeTelefono(telphonenTF.getText())) {
                    showPopUpWindow("Este numero de telefono esta usado en otra cuenta");
                }else if (dbc.existeDNI(dniTF.getText())) {
                    showPopUpWindow("El dni esta asignado a otra cuenta");
                }else {
                    try{
                        user.setUsername(usernameTF.getText());
                        user.setNombre_usuario(nameTF.getText());
                        user.setApellidos_usuario(surnameTF.getText());
                        user.setContrasena(cpasswordTF.getText());
                        user.setEmail_usuario(emailTF.getText());
                        user.setTelefono_usuario(telphonenTF.getText());
                        user.setDireccion_usuario(adressTF.getText());
                        user.setCodigo_postal_usuario(pcodeTF.getText());
                        user.setDni_usuario(dniTF.getText());
                        user.setFecha_nacimiento_usuario(Date.valueOf(birthTF.getValue()));
                        user.setEdad_usuario(user.getFecha_nacimiento_usuario());

                        nextPage("/FXML/UserGenre.fxml");
                    }catch (Exception e){
                        showPopUpWindow(e.getMessage());
                    }
                }
            }
        }
    }

    private boolean algunovacio(){
        return usernameTF.getText().isEmpty()||nameTF.getText().isEmpty()||surnameTF.getText().isEmpty()||passwordTF.getText().isEmpty()||cpasswordTF.getText().isEmpty()||emailTF.getText().isEmpty()||telphonenTF.getText().isEmpty()||adressTF.getText().isEmpty()||pcodeTF.getText().isEmpty()||dniTF.getText().isEmpty()||birthTF.getValue()==null;
    }

    public void showPopUpWindow(String text){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/PopUpWindowBad.fxml"));
            Parent dialogParent = loader.load();
            Scene dialogScene = new Scene(dialogParent);

            PopUpWindowController puwc=loader.getController();
            puwc.setErrorText(text);

            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(dialogScene);
            stage.setTitle("GYM-PRO");
            stage.show();
        } catch (Exception ex) {
            System.err.println("Error: "+ ex.getMessage());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
    }

    private void nextPage(String rutaFXML){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            UserGenreController controller = loader.getController();
            controller.setUser(getUser());

            Stage escenarioActual = (Stage) continueButton.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println("Error: "+e.getMessage());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
    }

    public void recuperarDatos(){
        user.setEs_hombre(null);
        user.setEdad_usuario(null);

        usernameTF.setText(user.getUsername());
        nameTF.setText(user.getNombre_usuario());
        surnameTF.setText(user.getApellidos_usuario());
        passwordTF.setText(user.getContrasena());
        cpasswordTF.setText(user.getContrasena());
        emailTF.setText(user.getEmail_usuario());
        telphonenTF.setText(user.getTelefono_usuario());
        adressTF.setText(user.getDireccion_usuario());
        pcodeTF.setText(user.getCodigo_postal_usuario());
        dniTF.setText(user.getDni_usuario());
        birthTF.setValue(user.getFecha_nacimiento_usuario().toLocalDate());
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

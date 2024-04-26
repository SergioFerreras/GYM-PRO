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

import java.time.LocalDateTime;

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
        if (algunovacio()){
            showPopUpWindow("Rellena todos los campos para continuar");
        }else{
            if (!passwordTF.getText().equals(cpasswordTF.getText())){
                showPopUpWindow("La contraseña no esta confirmada");
            }else {
                crearUsuario();
                user.setUsername(usernameTF.getText());
                user.setNombre_usuario(nameTF.getText());
                user.setApellidos_usuario(usernameTF.getText());
                user.setContraseña(passwordTF.getText());
                user.setEmail_usuario(emailTF.getText());
                user.setTelefono_usuario(telphonenTF.getText());
                user.setDireccion_usuario(adressTF.getText());
                user.setCodigo_postal_usuario(pcodeTF.getText());
                user.setDni_usuario(dniTF.getText());
                user.setFecha_nacimiento_usuario(birthTF.getValue());
                user.setEs_administrador(false);
                user.setEsta_subscrito(false);

                System.out.println(user.toString());

                nextPage("/FXML/UserGenre.fxml");
            }
        }
    }

    private boolean algunovacio(){
        return usernameTF.getText().isEmpty()||nameTF.getText().isEmpty()||surnameTF.getText().isEmpty()||passwordTF.getText().isEmpty()||cpasswordTF.getText().isEmpty()||emailTF.getText().isEmpty()||telphonenTF.getText().isEmpty()||adressTF.getText().isEmpty()||pcodeTF.getText().isEmpty()||dniTF.getText().isEmpty()||birthTF.getValue()==null;
    }

    public void showPopUpWindow(String text){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/PopUpWindow.fxml"));
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

            Stage escenarioActual = (Stage) continueButton.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println("Error: "+e.getMessage());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
    }

    private void crearUsuario(){
        this.user=new User();
    }

}

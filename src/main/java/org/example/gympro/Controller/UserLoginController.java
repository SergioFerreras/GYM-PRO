package org.example.gympro.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.gympro.Clases.User;
import org.example.gympro.Database.DataBaseController;

public class UserLoginController {

    User user;

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button loginButton;

    @FXML
    private Button signUpButton;

    @FXML
    private Button forgotPasswordButton;

    @FXML
    private Button crossButton;

    @FXML
    private void irSingUp(ActionEvent event) {
        signupPage("/FXML/UserSingUp.fxml");
    }

    @FXML
    private void cerrarVentana(ActionEvent event) {
        Stage stage = (Stage) crossButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void userlogin(ActionEvent event) {
        String username=usernameTextField.getText();
        String password=passwordTextField.getText();

        if (vacio(username)){
            showPopUpWindow("Escribe tu nombre de usuario");
        }else {
            if (vacio(password)){
                showPopUpWindow("Escribe la contraseña de tu usuario");
            }else{
                DataBaseController dbc=new DataBaseController();
                User user=dbc.seleccionarUserCompleto(username);

                if (user==null){
                    showPopUpWindow("No se ha encontrado ningun usuario con el username: "+username);
                }else{
                    if (user.getContrasena().equals(password)){
                        setUser(user);
                        gohomepage("/FXML/UserHome.fxml");
                    }else{
                        showPopUpWindow("Nombre de usuario o contraseña incorrecta");
                    }
                }
            }
        }
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


    private void gohomepage(String rutaFXML){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            UserHomeController controller = loader.getController();
            controller.setUser(getUser());

            Stage escenarioActual = (Stage) signUpButton.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println("Error: "+e.getMessage());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
    }

    private void signupPage(String rutaFXML){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            User usere=new User();

            UserSignUpController controller = loader.getController();
            controller.setUser(usere);

            Stage escenarioActual = (Stage) signUpButton.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println(e.toString());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
    }

    private boolean vacio(String text){
        if (text.equals("")|text.equals(null)){
            return true;
        }
        return false;
    }

    public void setUser(User user){
        this.user=user;
        user.setSuscrito();

    }

    public User getUser(){
        return this.user;
    }


}

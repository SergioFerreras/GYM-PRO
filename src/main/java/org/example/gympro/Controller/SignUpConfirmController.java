package org.example.gympro.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.example.gympro.Clases.User;
import org.example.gympro.Database.DataBaseController;

import java.sql.Date;

public class SignUpConfirmController {
    User user;

    @FXML
    private Button crossButton;
    @FXML
    private Button ConfirmButton;
    @FXML
    private Button changeButton;
    @FXML
    private Label UsernameLabel;
    @FXML
    private Label NameLabel;
    @FXML
    private Label EmailLabel;
    @FXML
    private Label BirthLabel;
    @FXML
    private Label WeightLabel;
    @FXML
    private Label AgeLabel;
    @FXML
    private Label AdressLabel;
    @FXML
    private Label PostalCodeLabel;
    @FXML
    private Label TelephoneLabel;
    @FXML
    private Label DniLabel;
    @FXML
    private Label GenreLabel;

    @FXML
    private void cerrarVentana(ActionEvent event) {
        Stage stage = (Stage) crossButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void gochange(ActionEvent event) {
        signupPage("/FXML/UserSingUp.fxml");
    }

    @FXML
    private void confirmData(ActionEvent event) {
        DataBaseController dbc=new DataBaseController();
        if (dbc.insertarNuevoUsuario(getUser())){
            explicationPage("/FXML/Explication.fxml");
        }else{
            System.out.println(false);
        }

        System.out.println("--_--"+user.toString());
    }


    private void signupPage(String rutaFXML){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            UserSignUpController controller = loader.getController();
            controller.setUser(getUser());
            controller.recuperarDatos();

            Stage escenarioActual = (Stage) ConfirmButton.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println(e.toString());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
    }

    private void explicationPage(String rutaFXML){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            Explication1Controller controller=loader.getController();
            controller.setUser(getUser());

            Stage escenarioActual = (Stage) ConfirmButton.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println(e.toString());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;

        UsernameLabel.setText(user.getUsername());
        NameLabel.setText(user.getNombre_usuario()+" "+user.getApellidos_usuario());
        EmailLabel.setText(user.getEmail_usuario());
        BirthLabel.setText(user.getFecha_nacimiento_usuario().toString());
        WeightLabel.setText(user.getPeso_usuario()+" Kg");
        AgeLabel.setText(user.getEdad_usuario()+" Years");
        AdressLabel.setText(user.getDireccion_usuario());
        PostalCodeLabel.setText(user.getCodigo_postal_usuario());
        TelephoneLabel.setText(user.getTelefono_usuario());
        DniLabel.setText(user.getDni_usuario());
        GenreLabel.setText(user.GenereToString());
    }


}

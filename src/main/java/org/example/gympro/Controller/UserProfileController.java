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

public class UserProfileController {
    User user;

    @FXML
    private Button crossButton;

    @FXML
    private Button homeButton;

    @FXML
    private Button signOutButton;

    @FXML
    private Button subscriptionButton;

    @FXML
    private Button shopButton;

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
    private Label fechafin;

    @FXML
    private void cerrarVentana(ActionEvent event) {
        Stage stage = (Stage) crossButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void irHome(ActionEvent event) {
        homePage("/FXML/UserHome.fxml");
    }

    @FXML
    private void irLogin(ActionEvent event) {
        loginPage("/FXML/UserLogin.fxml");
    }

    @FXML
    private void irSubscription(ActionEvent event) {
        subscriptionPage("/FXML/UserSubscribe.fxml");
    }

    @FXML
    private void irShop(ActionEvent event) {
        shopPage("/FXML/UserShop.fxml");
    }
    private void homePage(String rutaFXML){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            UserHomeController controller = loader.getController();
            controller.setUser(getUser());

            Stage escenarioActual = (Stage) homeButton.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println(e.toString());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
    }

    private void loginPage(String rutaFXML){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            Stage escenarioActual = (Stage) signOutButton.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println(e.toString());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
    }

    private void subscriptionPage(String rutaFXML){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            UserSubscribeController controller=loader.getController();
            controller.setUser(getUser());
            controller.setPrimeravez(false);

            Stage escenarioActual = (Stage) subscriptionButton.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println(e.toString());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
    }

    private void shopPage(String rutaFXML){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            UserShopController controller=loader.getController();
            controller.setUser(getUser());

            Stage escenarioActual = (Stage) shopButton.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println(e.toString());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
    }

    public String devolverFechaSuscripcionEndTXT(String username){
        String texto="You are not suscribed";
        Boolean suscrito=user.getSuscrito();
        DataBaseController dbc=new DataBaseController();
        Date fechafin=dbc.cogerFechaFinSuscripcion(username);

        if (suscrito){
            texto="Your suscription ends: "+fechafin.toString();
        }else{

        }
        return texto;
    }


    public void setUser(User user){
        this.user=user;
        user.setSuscrito();

        UsernameLabel.setText(user.getUsername());
        NameLabel.setText(user.getNombre_usuario()+" "+user.getApellidos_usuario());
        EmailLabel.setText(user.getEmail_usuario());
        BirthLabel.setText(user.getFecha_nacimiento_usuario().toString());
        WeightLabel.setText(String.valueOf(user.getPeso_usuario())+" Kg");
        AgeLabel.setText(String.valueOf(user.getEdad_usuario())+" Years");
        AdressLabel.setText(user.getDireccion_usuario());
        PostalCodeLabel.setText(user.getCodigo_postal_usuario());
        TelephoneLabel.setText(user.getTelefono_usuario());
        DniLabel.setText(user.getDni_usuario());
        GenreLabel.setText(user.GenereToString());
        fechafin.setText(devolverFechaSuscripcionEndTXT(user.getUsername()).toString());
    }

    public User getUser(){
        return this.user;
    }

}

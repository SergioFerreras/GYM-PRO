package org.example.gympro.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.gympro.Clases.User;

public class UserShopController {
    User user;
    @FXML
    private Button crossButton;

    @FXML
    private Button profileButton;

    @FXML
    private Button homeButton;

    @FXML
    private void cerrarVentana(ActionEvent event) {
        Stage stage = (Stage) crossButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void irProfile(ActionEvent event) {
        profilePage("/FXML/UserProfile.fxml");
    }

    @FXML
    private void irHome(ActionEvent event) {
        homePage("/FXML/UserHome.fxml");
    }

    private void profilePage(String rutaFXML){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            UserProfileController controller=loader.getController();
            controller.setUser(getUser());

            Stage escenarioActual = (Stage) profileButton.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println(e.toString());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
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

    public void setUser(User user){
        this.user=user;
        user.setSuscrito();
    }

    public User getUser(){
        return this.user;
    }
}

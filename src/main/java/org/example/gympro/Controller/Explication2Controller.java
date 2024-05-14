package org.example.gympro.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.gympro.Clases.User;

public class Explication2Controller {
    User user;
    @FXML
    private Button backButton;
    @FXML
    private Button crossButton;
    @FXML
    private Button Continuebuton;
    @FXML
    private void cerrarVentana(ActionEvent event) {
        Stage stage = (Stage) crossButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void irAtras(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Explication.fxml"));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            Explication1Controller controller=loader.getController();
            controller.setUser(getUser());

            Stage escenarioActual = (Stage) backButton.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println("Error: "+e.getMessage());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void irExplication(ActionEvent event) {
        expliactionPage("/FXML/Explication3.fxml");
    }

    private void expliactionPage(String rutaFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            Explication3Controller controller = loader.getController();
            controller.setUser(getUser());

            Stage escenarioActual = (Stage) Continuebuton.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println(e.toString());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
    }

    public void setUser(User user){
        this.user=user;
    }

    public User getUser(){
        return this.user;
    }
}

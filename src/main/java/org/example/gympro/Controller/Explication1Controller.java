package org.example.gympro.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.gympro.Clases.User;

public class Explication1Controller {
    User user;

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
    private void irExplication(ActionEvent event) {
        expliactionPage("/FXML/Explication2.fxml");
    }

    private void expliactionPage(String rutaFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            Explication2Controller controller = loader.getController();
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

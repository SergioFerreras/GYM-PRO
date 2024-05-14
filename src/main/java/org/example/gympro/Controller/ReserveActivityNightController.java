package org.example.gympro.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.gympro.Clases.User;

public class ReserveActivityNightController {
    User user;
    @FXML
    private Button backButton;
    @FXML
    private Button crossButton;
    @FXML
    private Button morningButton;
    @FXML
    private Button afternoonButton;

    @FXML
    private void cerrarVentana(ActionEvent event) {
        Stage stage = (Stage) crossButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void irAtras(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/UserHome.fxml"));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            Stage escenarioActual = (Stage) backButton.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println("Error: "+e.getMessage());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void irMorningA(ActionEvent event) {
        morningAPage("/FXML/ReserveActivityMorning.fxml");
    }

    private void morningAPage(String rutaFXML){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            Stage escenarioActual = (Stage) morningButton.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println(e.toString());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void irAfternoonA(ActionEvent event) {
        afternoonAPage("/FXML/ReserveActivityAfternoon.fxml");
    }

    private void afternoonAPage(String rutaFXML){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            Stage escenarioActual = (Stage) afternoonButton.getScene().getWindow();
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

package org.example.gympro.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.gympro.Clases.User;

public class UserGenreController {
    User user;
    @FXML
    private Button crossButton;
    @FXML
    private Button backButton;
    @FXML
    private Button ContinueButton;
    @FXML
    private RadioButton MaleRB;
    @FXML
    private RadioButton FamaleRB;

    @FXML
    private void cerrarVentana(ActionEvent event) {
        Stage stage = (Stage) crossButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void irAtras(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/UserSingUp.fxml"));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            UserSignUpController controller= loader.getController();
            controller.setUser(getUser());
            controller.recuperarDatos();

            Stage escenarioActual = (Stage) backButton.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println("Error: "+e.getMessage());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void nextPage(ActionEvent event) {
        if (MaleRB.isSelected()){
            user.setEs_hombre(true);
            weightpage("/FXML/UserWeightFind.fxml");
        } else if (FamaleRB.isSelected()) {
            user.setEs_hombre(false);
            weightpage("/FXML/UserWeightFind.fxml");
        }else {
            showPopUpWindowError("Elige un genero para continuar");
        }
    }

    private void weightpage(String fxml){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            UserWeightFindController controller=loader.getController();
            controller.setUser(getUser());

            Stage escenarioActual = (Stage) backButton.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println("Error: "+e.getMessage());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
    }

    public void showPopUpWindowError(String text){
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

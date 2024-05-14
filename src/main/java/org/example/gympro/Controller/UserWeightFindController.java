package org.example.gympro.Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.gympro.Clases.User;

public class UserWeightFindController {
    User user;
    @FXML
    private Button crossButton;
    @FXML
    private Button backButton;
    @FXML
    private Button continueButton;
    @FXML
    private TextField WeightTF;
    @FXML
    private ChoiceBox HowKnowTF;
    @FXML
    private void cerrarVentana(ActionEvent event) {
        Stage stage = (Stage) crossButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void irAtras(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/UserGenre.fxml"));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            UserGenreController controller = loader.getController();
            user.setPeso_usuario(0);
            user.setComoNosConoce(null);
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
    private void irSiguiente(ActionEvent event) {
        try {
            if (WeightTF.getText().isEmpty()|HowKnowTF.getValue()==null){
                showPopUpWindowError("Rellena todos los campos");
            }else{
                user.setPeso_usuario(Double.parseDouble(WeightTF.getText()));
                user.setComoNosConoce(HowKnowTF.getValue().toString());
                signupconfirm("/FXML/SignUpConfirm.fxml");
            }
        }catch (Exception e){
            showPopUpWindowError(e.getMessage());
        }
    }

    private void signupconfirm(String fxml){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            SignUpConfirmController controller=loader.getController();
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
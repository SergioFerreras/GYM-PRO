package org.example.gympro.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;
import java.util.Random;

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
    private WebView webView;
    @FXML
    private Label usernameLabel;
    @FXML
    private Pane pantallaCarga;
    @FXML
    private ProgressBar progressbar;

    @FXML
    private void initialize() {

        progressbar.getStyleClass().add("custom-progress-bar");

        WebEngine webEngine = webView.getEngine();
        webEngine.load("https://c78ad8-70.myshopify.com");
        webView.setZoom(0.65);

        barraCarga();
    }

    public void barraCarga() {
        Random random = new Random();
        double duracionAleatoria = 3 + random.nextDouble() * (10 - 3);
        Duration duration = Duration.seconds(duracionAleatoria);

        Timeline timeline = new Timeline(

                new KeyFrame(Duration.ZERO, event -> {
                    progressbar.setProgress(0);
                }),
                new KeyFrame(duration, event -> {
                    progressbar.setProgress(1);
                }),
                new KeyFrame(duration.multiply(0.25), event -> {
                    progressbar.setProgress(0.25);
                }),
                new KeyFrame(duration.multiply(0.5), event -> {
                    progressbar.setProgress(0.5);
                }),
                new KeyFrame(duration.multiply(0.75), event -> {
                    progressbar.setProgress(0.75);
                }),
                new KeyFrame(duration, event -> {
                    progressbar.setProgress(1);
                    pantallaCarga.setVisible(false);
                })
        );

        timeline.setCycleCount(1);
        timeline.play();
    }

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

    private void profilePage(String rutaFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            UserProfileController controller = loader.getController();
            controller.setUser(getUser());

            Stage escenarioActual = (Stage) profileButton.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println(e.toString());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
    }

    private void homePage(String rutaFXML) {
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

    public void setUser(User user) {
        this.user = user;
        user.setSuscrito();
        usernameLabel.setText(""+user.getUsername());
    }

    public User getUser() {
        return this.user;
    }
}

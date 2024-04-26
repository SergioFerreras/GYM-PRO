package org.example.gympro.Controller;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;


import java.io.IOException;


public class WaitingPageController {
    @FXML
    /*
    Este initialize lo que hace es mantener la pantalla durante 5 segundos y
    despues abrira la nueva pagina
     */
    private void initialize() {
        PauseTransition pause = new PauseTransition(Duration.seconds(5));

        pause.setOnFinished(event -> {
            cargarSiguienteFXML();
        });

        pause.play();
    }

    //Metodo para cargar el siguiente FXML
    public void cargarSiguienteFXML() {
        try {
            // Cargar el nuevo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/UserLogin.fxml"));
            Parent root = loader.load();

            // Obtener el controlador del nuevo FXML
            UserLoginController controller = loader.getController();

            Image icon = new Image(getClass().getResourceAsStream("/Elements/Icons/Logo.jpg"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.getIcons().add(icon);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.setTitle("GYM-PRO");

            // Mostrar la nueva ventana
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

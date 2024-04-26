package org.example.gympro.Clases;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;


import org.example.gympro.Controller.WaitingPageController;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Codigos para comenzar con el primer FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/WaitingPage.fxml"));
        Parent root = loader.load();

        Image icon = new Image(getClass().getResourceAsStream("/Elements/Icons/Logo.jpg"));

        // Establece el icono de la aplicación
        primaryStage.getIcons().add(icon);

        WaitingPageController controller = loader.getController();

        Scene scene = new Scene(root);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.setTitle("GYM-PRO");
        primaryStage.show();

        /*Ponemos una espera igual que en el controller para cuando salga la nueva pagina
        esta desapareca*/
        PauseTransition pause = new PauseTransition(Duration.seconds(4.80));

        pause.setOnFinished(event -> {
            primaryStage.close();
        });

        pause.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

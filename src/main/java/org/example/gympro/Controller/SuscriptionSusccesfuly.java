package org.example.gympro.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.example.gympro.Clases.User;
import org.example.gympro.Database.DataBaseController;
import org.example.gympro.DateController.DateController;

import java.io.File;
import java.net.MalformedURLException;

public class SuscriptionSusccesfuly {
    User user;
    @FXML
    private Button crossButton;
    @FXML
    private Button DoneButton;
    @FXML
    private Label PlanLabel;
    @FXML
    private Label SDateLabel;
    @FXML
    private Label EDateLabel;
    @FXML
    private ImageView PlanImage;


    public SuscriptionSusccesfuly() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        DateController dc=new DateController();
        DataBaseController dbc=new DataBaseController();
        String nombrePlan=dbc.cogerNombreSuscripcion(user.getUsername());

        this.user = user;
        user.setSuscrito();

        PlanLabel.setText("Chosen Plan: "+nombrePlan);
        SDateLabel.setText("Start Date: "+dc.getFechaActual());
        EDateLabel.setText("End Date: "+dbc.cogerFechaFinSuscripcion(user.getUsername()));
        if (nombrePlan.equals("Mensual")){
            Image image=getImage("src/main/resources/Elements/Icons/PesaBronce.png");
            PlanImage.setImage(image);
        }else if (nombrePlan.equals("Trimestral")){
            Image image=getImage("src/main/resources/Elements/Icons/PesaPlata.png");
            PlanImage.setImage(image);
        }else if (nombrePlan.equals("Anual")){
            Image image=getImage("src/main/resources/Elements/Icons/PesaOro.png");
            PlanImage.setImage(image);
        }else {
            System.err.println("ERROR INESPERADO");
            Image image=getImage("src/main/resources/Elements/Icons/CrossErrorImage.png");
            PlanImage.setImage(image);
        }
    }

    public Image getImage(String ruta){
        String imagePath = ruta;
        File file = new File(imagePath);
        Image image=null;
        try {
            String imageUrl = file.toURI().toURL().toString();
            image = new Image(imageUrl);

            return image;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return image;
    }

    @FXML
    private void cerrarVentana(ActionEvent event) {
        Stage stage = (Stage) crossButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void irHome(ActionEvent event) {
        goprofilepage("/FXML/UserProfile.fxml",DoneButton);
    }


    private void goprofilepage(String rutaFXML, Button button){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            UserProfileController controller = loader.getController();
            controller.setUser(getUser());

            Stage escenarioActual = (Stage) button.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println("Error: "+e.getMessage());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
    }
}

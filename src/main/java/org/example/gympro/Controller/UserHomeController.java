package org.example.gympro.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.gympro.Clases.Rutina;
import org.example.gympro.Clases.User;
import org.example.gympro.Database.DataBaseController;
import org.example.gympro.DateController.DateController;

import java.sql.Time;
import java.util.Calendar;

public class UserHomeController {

    User user;

    @FXML
    private Button crossButton;

    @FXML
    private Button reserveActivityButton;

    @FXML
    private Button profileButton;
    @FXML
    private Button shopButton;

    @FXML
    private Button myRutinesButton;

    @FXML
    private Button myGymButton;

    @FXML
    private Label hellouserlabel;
    @FXML
    private Label daygoodLabel;

    @FXML
    private Pane PanelUnsuscribed;

    @FXML
    private Pane bloqueoReserva;

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
    private void irReserveActivity(ActionEvent event) {
        reserveActivityPage("/FXML/ReserveActivityMorning.fxml");
    }

    @FXML
    private void irShop(ActionEvent event) {
        shopPage("/FXML/UserShop.fxml");
    }

    @FXML
    private void irRutines(ActionEvent event) {
        rutinesPage("/FXML/MyRutines.fxml");
    }

    @FXML
    private void irMyGym(ActionEvent event) {
        myGymPage("/FXML/MyGym.fxml");
    }

    private void myGymPage(String rutaFXML){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            MyGymController controller=loader.getController();
            controller.setUser(getUser());

            Stage escenarioActual = (Stage) myGymButton.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println(e.toString());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
    }

    private void rutinesPage(String rutaFXML){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            MyRutinesController controller=loader.getController();
            controller.setUser(getUser());

            Stage escenarioActual = (Stage) myRutinesButton.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println(e.toString());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
    }
    private void shopPage(String rutaFXML){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            UserShopController controller=loader.getController();
            controller.setUser(getUser());

            Stage escenarioActual = (Stage) shopButton.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println(e.toString());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
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

    private void reserveActivityPage(String rutaFXML){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            ReserveActivityMorningController controller=loader.getController();
            controller.setUser(getUser());

            Stage escenarioActual = (Stage) reserveActivityButton.getScene().getWindow();
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

        hellouserlabel.setText("Hello "+user.getUsername()+",");

        DateController dc=new DateController();
        daygoodLabel.setText(saludoSegunHora(dc.getHoraActual()));

        if (!user.getSuscrito()){
            reserveActivityButton.setDisable(true);
            myRutinesButton.setDisable(true);
            myGymButton.setDisable(true);
            PanelUnsuscribed.setVisible(true);
        }else{
            DataBaseController dbc=new DataBaseController();
            Rutina rutina=dbc.obtenerRutinasUsuario(getUser().getUsername());

            if (rutina==null){
                bloqueoReserva.setVisible(true);
                reserveActivityButton.setDisable(true);
            }
        }
    }

    public User getUser(){
        return this.user;
    }

    public static String saludoSegunHora(Time hora) {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(hora);
        int horaDelDia = calendario.get(Calendar.HOUR_OF_DAY);

        String saludo;

        if (horaDelDia >= 6 && horaDelDia < 12) {
            saludo = "Good Morning";
        } else if (horaDelDia >= 12 && horaDelDia < 20) {
            saludo = "Good Afternoon";
        } else {
            saludo = "Good Night";
        }

        return saludo;
    }

}

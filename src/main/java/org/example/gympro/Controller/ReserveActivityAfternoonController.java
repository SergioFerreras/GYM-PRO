package org.example.gympro.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.gympro.Clases.Rutina;
import org.example.gympro.Clases.User;
import org.example.gympro.Database.DataBaseController;

import java.sql.SQLException;
import java.time.LocalTime;

public class ReserveActivityAfternoonController {
    User user;
    @FXML
    private Button backButton;
    @FXML
    private Button crossButton;
    @FXML
    private Button nightButton;
    @FXML
    private Button morningButton;
    @FXML
    private Button NormalActivityButton;
    @FXML
    private Pane popUp;
    @FXML
    private Pane popUp1;
    @FXML
    private Pane popUp2;
    @FXML
    private Pane confimation;

    @FXML
    private Pane selected1;
    @FXML
    private Pane selected2;
    @FXML
    private Pane selected3;
    @FXML
    private Pane selected4;
    @FXML
    private Pane selected5;
    @FXML
    private Pane selected6;

    @FXML
    private Button iwseemore;
    @FXML
    private Button iwseemore2;
    @FXML
    private Button seletnormal;
    @FXML
    private Button seletespecial;
    @FXML
    private Button popupno;
    @FXML
    private Button confirmReserveButton;
    @FXML
    private Button especialActivityButton;
    @FXML
    private Button okeyButton;
    @FXML
    private RadioButton ochoanueve;
    @FXML
    private RadioButton nueveaonce;
    @FXML
    private RadioButton onceadoce;
    @FXML
    private RadioButton doceados;
    @FXML
    private RadioButton diezadoce;
    @FXML
    private RadioButton doceados2;
    @FXML
    private Label hourLabel;
    @FXML
    private Label activityLabel;
    @FXML
    private Label hourLabel1;
    @FXML
    private Label activityLabel1;


    @FXML
    private void closeConfirm(ActionEvent event) {
        unselectedButtons();
        NormalActivityButton.setDisable(false);
        especialActivityButton.setDisable(false);
        morningButton.setDisable(false);
        nightButton.setDisable(false);
        morningButton.setDisable(false);
        confimation.setVisible(false);
    }

    @FXML
    private void confirmReserve(ActionEvent event) {
        DataBaseController dbc=new DataBaseController();
        Rutina rutina=new Rutina();

        popUp.setVisible(false);
        confimation.setVisible(true);

        if (diezadoce.isSelected()){
            try {
                dbc.reserveActivity(getUser().getUsername(),"Cardio Activity 2","Sala 2",rutina.devolverParteCuerpoDDBBController(getUser().getUsername()));
            } catch (SQLException e) {
                showPopUpWindow("Ha ocurrido un error.");
            }
        }else if (doceados2.isSelected()){
            try {
                dbc.reserveActivity(getUser().getUsername(),"Yoga Activity 2","Sala 2",rutina.devolverParteCuerpoDDBBController(getUser().getUsername()));
            } catch (SQLException e) {
                showPopUpWindow("Ha ocurrido un error.");
            }
        }else if (ochoanueve.isSelected()){
            try {
                dbc.reserveActivity(getUser().getUsername(),"Normal Activity 5","Sala 1",rutina.devolverParteCuerpoDDBBController(getUser().getUsername()));
            } catch (SQLException e) {
                showPopUpWindow("Ha ocurrido un error.");
            }
        } else if (nueveaonce.isSelected()) {
            try {
                dbc.reserveActivity(getUser().getUsername(),"Normal Activity 6","Sala 1",rutina.devolverParteCuerpoDDBBController(getUser().getUsername()));
            } catch (SQLException e) {
                showPopUpWindow("Ha ocurrido un error.");
            }
        }else if (onceadoce.isSelected()) {
            try {
                dbc.reserveActivity(getUser().getUsername(),"Normal Activity 7","Sala 1",rutina.devolverParteCuerpoDDBBController(getUser().getUsername()));
            } catch (SQLException e) {
                showPopUpWindow("Ha ocurrido un error.");
            }
        }else if (doceados.isSelected()) {
            try {
                dbc.reserveActivity(getUser().getUsername(),"Normal Activity 8","Sala 1",rutina.devolverParteCuerpoDDBBController(getUser().getUsername()));
            } catch (SQLException e) {
                showPopUpWindow("Ha ocurrido un error.");
            }
        }

    }

    @FXML
    private void selectactivitye(ActionEvent event) {
        DataBaseController dbc=new DataBaseController();
        Rutina rutina=new Rutina();

        if (diezadoce.isSelected()){
            NormalActivityButton.setDisable(true);
            especialActivityButton.setDisable(true);
            popUp2.setVisible(false);
            popUp.setVisible(true);
            morningButton.setDisable(true);
            nightButton.setDisable(true);
            morningButton.setDisable(true);

            hourLabel.setText("Hour: 16:00-18:00");
            activityLabel.setText("Cardio Activity 2");

            hourLabel1.setText("Hour: 16:00-18:00");
            activityLabel1.setText("Cardio Activity 2");
        }else if (doceados2.isSelected()){
            NormalActivityButton.setDisable(true);
            especialActivityButton.setDisable(true);
            popUp2.setVisible(false);
            popUp.setVisible(true);
            morningButton.setDisable(true);
            nightButton.setDisable(true);
            morningButton.setDisable(true);

            hourLabel.setText("Hour: 18:00-20:00");
            activityLabel.setText("Yoga Activity 2");

            hourLabel1.setText("Hour: 18:00-20:00");
            activityLabel1.setText("Yoga Activity 2");
        }else {
            showPopUpWindow("No se ha seleccionado ninguna actividad");
        }
    }

    @FXML
    private void closespecial(ActionEvent event) {
        unselectedButtons();
        NormalActivityButton.setDisable(false);
        especialActivityButton.setDisable(false);
        popUp2.setVisible(false);
        diezadoce.setSelected(false);
        doceados2.setSelected(false);
    }

    @FXML
    private void openEspecial(ActionEvent event) {
        selectedButtons();

        DataBaseController dbc=new DataBaseController();
        Rutina rutina=new Rutina();

        LocalTime currentTime = LocalTime.now();
        LocalTime t1 = LocalTime.of(16 ,0);
        LocalTime t2 = LocalTime.of(18, 0);


        NormalActivityButton.setDisable(true);
        especialActivityButton.setDisable(true);
        popUp2.setVisible(true);

        if (!dbc.checkAvailability(getUser().getUsername(),"Cardio Activity 2",rutina.devolverParteCuerpoDDBBController(getUser().getUsername()))){
            diezadoce.setDisable(true);
        }
        if (!dbc.checkAvailability(getUser().getUsername(),"Yoga Activity 2",rutina.devolverParteCuerpoDDBBController(getUser().getUsername()))){
            doceados2.setDisable(true);
        }

        if (currentTime.isAfter(t1)){
            diezadoce.setDisable(true);
        }
        if (currentTime.isAfter(t2)){
            doceados2.setDisable(true);
        }

    }

    @FXML
    private void closepopup(ActionEvent event) {
        unselectedButtons();
        popUp.setVisible(false);
        NormalActivityButton.setDisable(false);
        especialActivityButton.setDisable(false);
        ochoanueve.setSelected(false);
        nueveaonce.setSelected(false);
        onceadoce.setSelected(false);
        doceados.setSelected(false);
        diezadoce.setSelected(false);
        doceados2.setSelected(false);
    }

    @FXML
    private void selectactivityn(ActionEvent event) {
        DataBaseController dbc=new DataBaseController();
        Rutina rutina=new Rutina();

        if (ochoanueve.isSelected()){
            NormalActivityButton.setDisable(true);
            especialActivityButton.setDisable(true);
            popUp1.setVisible(false);
            popUp.setVisible(true);
            morningButton.setDisable(true);
            nightButton.setDisable(true);
            morningButton.setDisable(true);

            hourLabel.setText("Hour: 14:00-15:30");
            activityLabel.setText("Normal Activity 5");

            hourLabel1.setText("Hour: 14:00-15:30");
            activityLabel1.setText("Normal Activity 5");
        } else if (nueveaonce.isSelected()) {
            NormalActivityButton.setDisable(true);
            especialActivityButton.setDisable(true);
            popUp1.setVisible(false);
            popUp.setVisible(true);
            morningButton.setDisable(true);
            nightButton.setDisable(true);
            morningButton.setDisable(true);

            hourLabel.setText("Hour: 15:30-17:00");
            activityLabel.setText("Normal Activity 6");

            hourLabel1.setText("Hour: 15:30-17:00");
            activityLabel1.setText("Normal Activity 6");
        }else if (onceadoce.isSelected()) {
            NormalActivityButton.setDisable(true);
            especialActivityButton.setDisable(true);
            popUp1.setVisible(false);
            popUp.setVisible(true);
            morningButton.setDisable(true);
            nightButton.setDisable(true);
            morningButton.setDisable(true);

            hourLabel.setText("Hour: 17:00-18:30");
            activityLabel.setText("Normal Activity 7");

            hourLabel1.setText("Hour: 17:00-18:30");
            activityLabel1.setText("Normal Activity 7");
        }else if (doceados.isSelected()) {
            NormalActivityButton.setDisable(true);
            especialActivityButton.setDisable(true);
            popUp1.setVisible(false);
            popUp.setVisible(true);
            morningButton.setDisable(true);
            nightButton.setDisable(true);
            morningButton.setDisable(true);

            hourLabel.setText("Hour: 18:30-20:00");
            activityLabel.setText("Normal Activity 8");

            hourLabel1.setText("Hour: 18:30-20:00");
            activityLabel1.setText("Normal Activity 8");
        }else {
            showPopUpWindow("No se ha seleccionado ninguna actividad");
        }
    }

    public void showPopUpWindow(String text){
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
    @FXML
    private void openNormala(ActionEvent event) {
        selectedButtons();

        DataBaseController dbc=new DataBaseController();
        Rutina rutina=new Rutina();

        LocalTime currentTime = LocalTime.now();
        LocalTime t1 = LocalTime.of(14, 0);
        LocalTime t2 = LocalTime.of(15, 30);
        LocalTime t3 = LocalTime.of(17, 0);
        LocalTime t4 = LocalTime.of(18, 30);

        NormalActivityButton.setDisable(true);
        especialActivityButton.setDisable(true);
        popUp1.setVisible(true);

        if (!dbc.checkAvailability(getUser().getUsername(),"Normal Activity 5",rutina.devolverParteCuerpoDDBBController(getUser().getUsername()))){
            ochoanueve.setDisable(true);
        }
        if (!dbc.checkAvailability(getUser().getUsername(),"Normal Activity 6",rutina.devolverParteCuerpoDDBBController(getUser().getUsername()))) {
            nueveaonce.setDisable(true);
        }
        if (!dbc.checkAvailability(getUser().getUsername(),"Normal Activity 7",rutina.devolverParteCuerpoDDBBController(getUser().getUsername()))) {
            onceadoce.setDisable(true);
        }
        if (!dbc.checkAvailability(getUser().getUsername(),"Normal Activity 8",rutina.devolverParteCuerpoDDBBController(getUser().getUsername()))) {
            doceados.setDisable(true);
        }

        if (currentTime.isAfter(t1)){
            ochoanueve.setDisable(true);
        }
        if (currentTime.isAfter(t2)) {
            nueveaonce.setDisable(true);
        }
        if (currentTime.isAfter(t3)) {
            onceadoce.setDisable(true);
        }
        if (currentTime.isAfter(t4)) {
            doceados.setDisable(true);
        }
    }


    @FXML
    private void closenormala(ActionEvent event) {
        unselectedButtons();
        NormalActivityButton.setDisable(false);
        especialActivityButton.setDisable(false);
        popUp1.setVisible(false);
        ochoanueve.setSelected(false);
        nueveaonce.setSelected(false);
        onceadoce.setSelected(false);
        doceados.setSelected(false);
    }


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

            UserHomeController controller = loader.getController();
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
    private void irNightA(ActionEvent event) {
        nightAPage("/FXML/ReserveActivityNight.fxml");
    }

    private void nightAPage(String rutaFXML){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            ReserveActivityNightController controller=loader.getController();
            controller.setUser(getUser());

            Stage escenarioActual = (Stage) nightButton.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println(e.toString());
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

            ReserveActivityMorningController controller=loader.getController();
            controller.setUser(getUser());

            Stage escenarioActual = (Stage) morningButton.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println(e.toString());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
    }


    private void selectedButtons(){
        DataBaseController dbc=new DataBaseController();
        String reserva=dbc.getReservedActivityByUsername(getUser().getUsername());

        if (reserva==null){

        }else{
            if(reserva.equals("Cardio Activity 2")){
                diezadoce.setDisable(true);
                selected5.setVisible(true);
            } else if (reserva.equals("Yoga Activity 2")) {
                doceados2.setDisable(true);
                selected6.setVisible(true);
            }else if (reserva.equals("Normal Activity 5")) {
                ochoanueve.setDisable(true);
                selected1.setVisible(true);
            }else if (reserva.equals("Normal Activity 6")) {
                nueveaonce.setDisable(true);
                selected2.setVisible(true);
            }else if (reserva.equals("Normal Activity 7")) {
                onceadoce.setDisable(true);
                selected3.setVisible(true);
            }else if (reserva.equals("Normal Activity 8")) {
                doceados.setDisable(true);
                selected4.setVisible(true);
            }
        }
    }

    private void unselectedButtons(){
        ochoanueve.setDisable(false);
        nueveaonce.setDisable(false);
        onceadoce.setDisable(false);
        doceados.setDisable(false);
        diezadoce.setDisable(false);
        doceados2.setDisable(false);

        selected1.setVisible(false);
        selected2.setVisible(false);
        selected3.setVisible(false);
        selected4.setVisible(false);
        selected5.setVisible(false);
        selected6.setVisible(false);
    }


    public void setUser(User user){
        this.user=user;
    }

    public User getUser(){
        return this.user;
    }
}

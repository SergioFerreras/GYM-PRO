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
import org.example.gympro.Database.DataBaseController;
import org.example.gympro.DateController.DateController;

import java.sql.Date;

public class UserSubscribeController {
    User user;
    boolean primeravez;
    @FXML
    private Button crossButton;
    @FXML
    private RadioButton nothanksb;
    @FXML
    private RadioButton monthlyRButton;
    @FXML
    private RadioButton threeMontsRButton;
    @FXML
    private RadioButton yearRButton;
    @FXML
    private Button suscribeNowButton;

    @FXML
    private void cerrarVentana(ActionEvent event) {
        Stage stage = (Stage) crossButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void irAtras(ActionEvent event) {
        if (primeravez){
            homepage();
        }else{
            profilepage();
        }
    }

    private void profilepage(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/UserProfile.fxml"));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            UserProfileController controller=loader.getController();
            controller.setUser(getUser());

            Stage escenarioActual = (Stage) nothanksb.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println("Error: "+e.getMessage());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
    }

    private void homepage(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/UserHome.fxml"));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            UserHomeController controller=loader.getController();
            controller.setUser(getUser());

            Stage escenarioActual = (Stage) nothanksb.getScene().getWindow();
            escenarioActual.setScene(otraPaginaScene);
        } catch (Exception e) {
            System.err.println("Error: "+e.getMessage());
            Stage stage = (Stage) crossButton.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void suscribirse(ActionEvent event) {
        DataBaseController dbc=new DataBaseController();
        DateController dc=new DateController();
        Date fechactual=dc.getFechaActual();
        Date fechaFinSus=dbc.cogerFechaFinSuscripcion(user.getUsername());

        try {
            if (monthlyRButton.isSelected()) {
                if (fechaFinSus==null){
                    Date fechaActualizada=dc.suscripcionUnMes(fechactual);
                    dbc.actualizarSuscripcion(user.getUsername(),"Mensual",fechactual.toString(),fechaActualizada.toString());
                    suscribeSusccesfulyPage("/FXML/SuscriptionOkey.fxml",suscribeNowButton);
                }else{
                    Date fechaActualizada=dc.suscripcionUnMes(fechaFinSus);
                    dbc.actualizarSuscripcion(user.getUsername(),"Mensual",fechactual.toString(),fechaActualizada.toString());
                    suscribeSusccesfulyPage("/FXML/SuscriptionOkey.fxml",suscribeNowButton);
                }
            } else if (threeMontsRButton.isSelected()) {
                if (fechaFinSus==null){
                    Date fechaActualizada=dc.suscripcionTresMes(fechactual);
                    dbc.actualizarSuscripcion(user.getUsername(),"Trimestral",fechactual.toString(),fechaActualizada.toString());
                    suscribeSusccesfulyPage("/FXML/SuscriptionOkey.fxml",suscribeNowButton);
                }else{
                    Date fechaActualizada=dc.suscripcionTresMes(fechaFinSus);
                    dbc.actualizarSuscripcion(user.getUsername(),"Trimestral",fechactual.toString(),fechaActualizada.toString());
                    suscribeSusccesfulyPage("/FXML/SuscriptionOkey.fxml",suscribeNowButton);
                }
            } else if (yearRButton.isSelected()) {
                if (fechaFinSus==null){
                    Date fechaActualizada=dc.suscripcionUnAño(fechactual);
                    dbc.actualizarSuscripcion(user.getUsername(),"Anual",fechactual.toString(),fechaActualizada.toString());
                    suscribeSusccesfulyPage("/FXML/SuscriptionOkey.fxml",suscribeNowButton);
                }else{
                    Date fechaActualizada=dc.suscripcionUnAño(fechaFinSus);
                    dbc.actualizarSuscripcion(user.getUsername(),"Anual",fechactual.toString(),fechaActualizada.toString());
                    suscribeSusccesfulyPage("/FXML/SuscriptionOkey.fxml",suscribeNowButton);
                }
            }else {
                showPopUpWindowError("No se ha seleccionado ningun plan");
            }
        }catch (Exception e){
            showPopUpWindowError(e.getMessage());
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

    private void suscribeSusccesfulyPage(String rutaFXML, Button button){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent otraPaginaParent = loader.load();
            Scene otraPaginaScene = new Scene(otraPaginaParent);

            SuscriptionSusccesfuly controller=loader.getController();
            controller.setUser(getUser());

            Stage escenarioActual = (Stage) button.getScene().getWindow();
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
    }

    public User getUser() {
        return user;
    }

    public boolean isPrimeravez() {
        return primeravez;
    }

    public void setPrimeravez(boolean primeravez) {
        this.primeravez = primeravez;
    }
}

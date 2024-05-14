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

public class MyRutinesController {
    User user;
    String rutina;
    @FXML
    private Button backButton;
    @FXML
    private Button crossButton;
    @FXML
    private Button r1button;
    @FXML
    private Button r2button;
    @FXML
    private Button r3button;
    @FXML
    private Button r4button;
    @FXML
    private Button r5button;
    @FXML
    private Button r6button;
    @FXML
    private Button yeschange;
    @FXML
    private Button nochange;
    @FXML
    private Pane r1selected;
    @FXML
    private Pane r2selected;
    @FXML
    private Pane r3selected;
    @FXML
    private Pane r4selected;
    @FXML
    private Pane r5selected;
    @FXML
    private Pane r6selected;
    @FXML
    private Label rlabelactual;
    @FXML
    private Label rlabelchange;

    @FXML
    private Pane popUp;

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

            UserHomeController controller= loader.getController();
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
    private void r1pulsado(ActionEvent event) {
        setRutina("Rutina1");
        setpopUp(true,"Rutina1");
    }

    @FXML
    private void r2pulsado(ActionEvent event) {
        setRutina("Rutina2");
        setpopUp(true,"Rutina2");
    }

    @FXML
    private void r3pulsado(ActionEvent event) {
        setRutina("Rutina3");
        setpopUp(true,"Rutina3");
    }

    @FXML
    private void r4pulsado(ActionEvent event) {
        setRutina("Rutina4");
        setpopUp(true,"Rutina4");
    }

    @FXML
    private void r5pulsado(ActionEvent event) {
        setRutina("Rutina5");
        setpopUp(true,"Rutina5");
    }

    @FXML
    private void r6pulsado(ActionEvent event) {
        setRutina("Rutina6");
        setpopUp(true,"Rutina6");
    }

    private void setpopUp(boolean buleano, String nombreRutina){
        DataBaseController dbc=new DataBaseController();
        Rutina rutina=dbc.obtenerRutinasUsuario(getUser().getUsername());

        if (rutina!=null){
            String nombreRutinaActual=rutina.getNombre();
            rlabelactual.setText(nombreRutinaActual);
            rlabelchange.setText(nombreRutina);
        }else{
            rlabelactual.setText("Empty");
            rlabelchange.setText(nombreRutina);
        }

        if (buleano==true){
            setdisable(buleano);
            popUp.setVisible(buleano);
        }else{
            setdisable(buleano);
            popUp.setVisible(buleano);
        }
    }

    private void setdisable(boolean buleano){
            r1button.setDisable(buleano);
            r2button.setDisable(buleano);
            r3button.setDisable(buleano);
            r4button.setDisable(buleano);
            r5button.setDisable(buleano);
            r6button.setDisable(buleano);
    }


    @FXML
    private void changeRutine(ActionEvent event) {
        String rutina=getRutina();
        DataBaseController dbc=new DataBaseController();

        if (rutina.equals("Rutina1")){
            dbc.asignarOActualizarRutina(getUser().getUsername(),getRutina());
            setselected();
            setdisable(false);
            popUp.setVisible(false);
        } else if (rutina.equals("Rutina2")) {
            dbc.asignarOActualizarRutina(getUser().getUsername(),getRutina());
            setselected();
            setdisable(false);
            popUp.setVisible(false);
        } else if (rutina.equals("Rutina3")) {
            dbc.asignarOActualizarRutina(getUser().getUsername(),getRutina());
            setselected();
            setdisable(false);
            popUp.setVisible(false);
        } else if (rutina.equals("Rutina4")) {
            dbc.asignarOActualizarRutina(getUser().getUsername(),getRutina());
            setselected();
            setdisable(false);
            popUp.setVisible(false);
        } else if (rutina.equals("Rutina5")) {
            dbc.asignarOActualizarRutina(getUser().getUsername(),getRutina());
            setselected();
            setdisable(false);
            popUp.setVisible(false);
        } else if (rutina.equals("Rutina6")) {
            dbc.asignarOActualizarRutina(getUser().getUsername(),getRutina());
            setselected();
            setdisable(false);
            popUp.setVisible(false);
        }
    }

    @FXML
    private void cancelChange(ActionEvent event) {
        setpopUp(false,"hola");
    }

    private void setselected() {
        DataBaseController dbc=new DataBaseController();
        Rutina rutina=dbc.obtenerRutinasUsuario(getUser().getUsername());

        if (rutina!=null){
            String nombreRutina=rutina.getNombre();
            if (nombreRutina.equals("Rutina1")){
                r1selected.setVisible(true);
                r2selected.setVisible(false);
                r3selected.setVisible(false);
                r4selected.setVisible(false);
                r5selected.setVisible(false);
                r6selected.setVisible(false);
            }else if (nombreRutina.equals("Rutina2")){
                r1selected.setVisible(false);
                r2selected.setVisible(true);
                r3selected.setVisible(false);
                r4selected.setVisible(false);
                r5selected.setVisible(false);
                r6selected.setVisible(false);
            }else if (nombreRutina.equals("Rutina3")){
                r1selected.setVisible(false);
                r2selected.setVisible(false);
                r3selected.setVisible(true);
                r4selected.setVisible(false);
                r5selected.setVisible(false);
                r6selected.setVisible(false);
            }else if (nombreRutina.equals("Rutina4")){
                r1selected.setVisible(false);
                r2selected.setVisible(false);
                r3selected.setVisible(false);
                r4selected.setVisible(true);
                r5selected.setVisible(false);
                r6selected.setVisible(false);
            }else if (nombreRutina.equals("Rutina5")){
                r1selected.setVisible(false);
                r2selected.setVisible(false);
                r3selected.setVisible(false);
                r4selected.setVisible(false);
                r5selected.setVisible(true);
                r6selected.setVisible(false);
            }else if (nombreRutina.equals("Rutina6")){
                r1selected.setVisible(false);
                r2selected.setVisible(false);
                r3selected.setVisible(false);
                r4selected.setVisible(false);
                r5selected.setVisible(false);
                r6selected.setVisible(true);
            }
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        setselected();
    }

    public String getRutina() {
        return rutina;
    }

    public void setRutina(String rutina) {
        this.rutina = rutina;
    }
}

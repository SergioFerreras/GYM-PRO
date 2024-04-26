package org.example.gympro.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PopUpWindowController {
    private String errorText;

    @FXML
    private Label text;

    @FXML
    private Button crossButton;

    public PopUpWindowController() {
    }

    public PopUpWindowController(String errorText) {
        text.setText(errorText);
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
        text.setText(errorText);
    }

    @FXML
    private void cerrarVentana(ActionEvent event) {
        Stage stage = (Stage) crossButton.getScene().getWindow();
        stage.close();
    }
}

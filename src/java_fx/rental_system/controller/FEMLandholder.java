package java_fx.rental_system.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FEMLandholder implements Initializable {

    @FXML
    TextField propid;
    @FXML
    private ComboBox typecombo;
    @FXML
    private ComboBox numroom;
    @FXML
    private ComboBox status;
    @FXML
    private Button search;
    @FXML
    private Button clear;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typecombo.getItems().setAll("1","2","3");
        numroom.getItems().setAll("22","33","44");
        status.getItems().setAll("ffff","fdffdf");
        search.setOnAction(event -> {
            HBox pane = new HBox();
            pane.getChildren().add(new Text("clicked search!"));
            Stage click = new Stage();
            click.setScene(new Scene(pane));
            new Stage().show();
        });

        clear.setOnAction(event -> {
            HBox pane = new HBox();
            pane.getChildren().addAll(new Button("clicked clear!"),new Label("clicked clear!"));
            Stage click = new Stage();
            click.setScene(new Scene(pane));
            new Stage().show();
        });
    }
}

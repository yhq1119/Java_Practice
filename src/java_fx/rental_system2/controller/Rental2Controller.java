package java_fx.rental_system2.controller;

import java_fx.rental_system2.model.Property;
import java_fx.rental_system2.model.RentalSystem;
import java_fx.rental_system2.view.MainViewPane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Rental2Controller {
    private RentalSystem model;
    private MainViewPane view;

    public Rental2Controller(RentalSystem model, MainViewPane view) {
        this.model = model;
        this.view = view;
        initialize();
    }

    public Scene getView() {
        return new Scene(view);
    }

    private void initialize() {

        FlowPane flowPane = new FlowPane();
        for (Property p : this.model.getProperties()) {
            Button button = new Button(p.toString());
            button.setOnAction(event -> {
                Stage stage = new Stage();
                stage.setTitle(p.toString());
                stage.show();
            });
          flowPane.getChildren().add(button);
        }
        this.view.getContentPane().getChildren().add(flowPane);

    }
}

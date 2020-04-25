package java_fx.rental_system.controller;

import java_fx.rental_system.view.MainPane;
import javafx.scene.Scene;

public class Controller {
    private MainPane view;

    public Controller(MainPane view) {
        this.view = view;
    }

    public Scene getView() {
        return new Scene(view);
    }
}

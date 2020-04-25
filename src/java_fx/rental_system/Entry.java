package java_fx.rental_system;

import java_fx.rental_system.controller.Controller;
import java_fx.rental_system.view.MainPane;
import javafx.application.Application;
import javafx.stage.Stage;

public class Entry extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainPane view = new MainPane();
        Controller controller = new Controller(view);
        primaryStage.setScene(controller.getView());
        primaryStage.show();
    }
}

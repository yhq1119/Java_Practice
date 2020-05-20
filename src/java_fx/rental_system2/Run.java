package java_fx.rental_system2;

import java_fx.rental_system2.controller.Rental2Controller;
import java_fx.rental_system2.model.RentalSystem;
import java_fx.rental_system2.view.MainViewPane;
import javafx.application.Application;
import javafx.stage.Stage;

public class Run extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        RentalSystem model = new RentalSystem();
        MainViewPane view = new MainViewPane();

        Rental2Controller controller = new Rental2Controller(model,view);
        primaryStage.setScene(controller.getView());
        primaryStage.show();
    }
}

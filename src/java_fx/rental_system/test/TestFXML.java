package java_fx.rental_system.test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestFXML  extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("java_fx/rental_system/resources/1000x600_MainWindow.fxml"));
        primaryStage.setScene(new Scene(root,1000,600));
        primaryStage.show();
    }
}

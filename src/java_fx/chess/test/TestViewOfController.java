package java_fx.chess.test;

import java_fx.chess.controller.MainController;
import java_fx.chess.model.gameboard.GameBoard;
import java_fx.chess.view.MainPane;
import javafx.application.Application;
import javafx.stage.Stage;

public class TestViewOfController extends Application {
    @Override
    public void start(Stage primaryStage) {
        MainPane view = new MainPane(8, 8);
        GameBoard model = new GameBoard(
                "p1", "p2",
                20, true, true);
        MainController controller = new MainController(model, view);
        primaryStage.setScene(controller.getView());
        primaryStage.show();
    }
}

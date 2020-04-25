package java_fx.chess_2;

import java_fx.chess_2.controller.Controller;
import java_fx.chess_2.model.GameModel;
import java_fx.chess_2.model.player.Player;
import java_fx.chess_2.view.MainPane;
import javafx.application.Application;
import javafx.stage.Stage;

public class IntegrateTest extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        int rows = 8;
        int cols = 8;
        int turns = 20;
        boolean randomTurn = 0.5>Math.random();
        GameModel gameModel = new GameModel(
                turns,
                rows,
                cols,
                new Player("P1 Name"),
                new Player("P2 Name"),
                randomTurn);
        MainPane gameView = new MainPane(rows, cols);
        Controller controller = new Controller(gameModel,gameView);
        primaryStage.setScene(controller.getScene());
        primaryStage.show();
    }
}

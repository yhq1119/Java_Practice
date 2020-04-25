package java_fx.chess.test;

import java_fx.chess.view.BoardPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestBoardPaneView  extends Application {

    BoardPane boardPane = new BoardPane(8,8);

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene( new Scene(boardPane));
        primaryStage.show();
    }
}

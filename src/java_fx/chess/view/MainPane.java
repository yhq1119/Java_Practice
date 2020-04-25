package java_fx.chess.view;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainPane extends HBox {

    private BoardPane boardPane;
    private InfoPane infoPane;
    public MainPane(int row, int col){
        boardPane = new BoardPane(row, col);
        infoPane = new InfoPane();
        VBox leftPanel = new VBox();
        VBox rightPanel = new VBox();

        rightPanel.getChildren().add(infoPane);

        leftPanel.getChildren().add(boardPane);
        this.getChildren().addAll(leftPanel,rightPanel);
    }

    public BoardPane getBoardPane() {
        return boardPane;
    }

    public InfoPane getInfoPane() {
        return infoPane;
    }
}

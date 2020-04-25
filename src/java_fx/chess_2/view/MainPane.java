package java_fx.chess_2.view;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainPane extends VBox {

    private BoardPane boardPane;
    private InfoPane infoPane;

    public MainPane(int row, int col) {

        boardPane = new BoardPane(row, col);
        infoPane = new InfoPane();
        HBox main = new HBox();
        VBox leftFill = new VBox();
        HBox upFill = new HBox();
        HBox bottomFill = new HBox();
        VBox rightFill = new VBox();
        VBox leftPanel = new VBox();
        VBox rightPanel = new VBox();

        rightPanel.getChildren().add(infoPane);
        leftPanel.getChildren().add(boardPane);

        main.getChildren().addAll(leftFill,leftPanel, rightPanel,rightFill);
        this.getChildren().addAll(upFill,main,bottomFill);
        this.setSpacing(15);
        this.setStyle("-fx-background-color: #78b0fd");
    }

    public BoardPane getBoardPane() {
        return this.boardPane;
    }

    public InfoPane getInfoPane() {
        return this.infoPane;
    }
}

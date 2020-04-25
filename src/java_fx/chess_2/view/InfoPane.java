package java_fx.chess_2.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class InfoPane extends VBox {

    Label generalInfo;
    Label gameInfo;
    Label whoseTurn;
    Label gameTurns;
    Label playerOnePieces;
    Label playerTwoPieces;
    Button splitBtn;
    public InfoPane() {
        splitBtn = new Button("SPLIT");
       splitBtn.setDisable(true);
        generalInfo = new Label();
        gameInfo = new Label();
        whoseTurn = new Label();
        gameTurns = new Label();
        playerOnePieces = new Label();
        playerTwoPieces = new Label();

        generalInfo.setText("General Info");
        gameInfo.setText("Game Info");
        whoseTurn.setText("Whose turn");
        gameTurns.setText("Game Turns");
        playerOnePieces.setText("Player One Remaining Pieces");
        playerTwoPieces.setText("Player Two Remaining Pieces");

        this.getChildren().addAll(splitBtn,generalInfo,gameInfo,whoseTurn,gameTurns,playerOnePieces,playerTwoPieces);
        this.setMinWidth(300);
    }

    public Label getGeneralInfo() {
        return generalInfo;
    }

    public Label getGameInfo() {
        return gameInfo;
    }

    public Label getGameTurns() {
        return gameTurns;
    }

    public Label getPlayerOnePieces() {
        return playerOnePieces;
    }

    public Label getPlayerTwoPieces() {
        return playerTwoPieces;
    }

    public Label getWhoseTurn() {
        return whoseTurn;
    }

    public Button getSplitBtn() {
        return splitBtn;
    }
}

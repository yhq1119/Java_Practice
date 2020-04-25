package java_fx.chess.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class InfoPane extends HBox {
    private Button split = new Button("SPLIT PIECE");
    private Label ScoreOfWhite = new Label();
    private Label ScoreOfBlack = new Label();
    private Label RemainingTurns = new Label();
    private Label CurrentPlayerTurn = new Label();
    private Label Information = new Label();

    public InfoPane() {

        split.setStyle("-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:11pt;-fx-text-fill:#d8d8d8;");

        int width = 160;

        Label Title1 = new Label("WHITE");
        Label Title2 = new Label("BLACK");
        Label Title3 = new Label("Turns Remaining");

        Title1.setStyle("-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:11pt;-fx-text-fill:#d8d8d8;");
        Title2.setStyle("-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:11pt;-fx-text-fill:#d8d8d8;");
        Title3.setStyle("-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:11pt;-fx-text-fill:#d8d8d8;");

        Title1.setTextAlignment(TextAlignment.CENTER);
        Title1.setAlignment(Pos.CENTER);
        Title2.setAlignment(Pos.CENTER);
        Title3.setAlignment(Pos.CENTER);

        HBox rightFit = new HBox();
        HBox topFit = new HBox();
        HBox bottomFit = new HBox();

        VBox pane1 = new VBox();
        pane1.getChildren().addAll(topFit, split, Title1, ScoreOfWhite, Title2, ScoreOfBlack, Title3, RemainingTurns, bottomFit);

        ScoreOfWhite.setPrefWidth(160);
        ScoreOfBlack.setStyle("-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:11pt;-fx-text-fill:#d8d8d8;");
        ScoreOfWhite.setStyle("-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:11pt;-fx-text-fill:#d8d8d8;");
        RemainingTurns.setStyle("-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:11pt;-fx-text-fill:#d8d8d8;");

        ScoreOfBlack.setPrefWidth(160);
        RemainingTurns.setPrefWidth(160);
        ScoreOfBlack.setAlignment(Pos.CENTER);
        ScoreOfBlack.setTextAlignment(TextAlignment.CENTER);
        ScoreOfWhite.setAlignment(Pos.CENTER);
        RemainingTurns.setAlignment(Pos.CENTER);
        pane1.setAlignment(Pos.CENTER_LEFT);
        pane1.setSpacing(20);

        split.setPrefWidth(width);

        Title1.setPrefWidth(width);
        Title2.setPrefWidth(width);
        Title3.setPrefWidth(width);

        Label ScoreT = new Label("SCORE");

        ScoreT.setAlignment(Pos.CENTER);
        ScoreT.setStyle("-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:11pt;-fx-text-fill:#d8d8d8;");
        ScoreT.setPrefWidth(160);
        ScoreT.setPrefHeight(40);

        VBox ScoreBoard = new VBox();
        HBox WScore = new HBox();
        WScore.setPrefHeight(40);
        WScore.getChildren().addAll(Title1, ScoreOfWhite);

        CurrentPlayerTurn.setStyle("-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:11pt;-fx-text-fill:#d8d8d8;");
        CurrentPlayerTurn.setText("N/A");

        HBox BScore = new HBox();
        HBox q = new HBox();
        HBox q2 = new HBox();

        BScore.getChildren().addAll(Title2, ScoreOfBlack);
        BScore.setPrefHeight(40);
        ScoreBoard.getChildren().addAll(ScoreT, q, WScore, BScore, q2);

        q.setMinHeight(20);

        ScoreBoard.setSpacing(0);
        ScoreBoard.setAlignment(Pos.CENTER);

        Label remainingT = new Label("TURNS LEFT");
        remainingT.setAlignment(Pos.CENTER);
        remainingT.setPrefWidth(160);
        remainingT.setStyle("-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:11pt;-fx-text-fill:#d8d8d8;");

        VBox TurnsRemaining = new VBox();
        TurnsRemaining.getChildren().addAll(remainingT, RemainingTurns);

        VBox CurrentTurn = new VBox();
        Label currentT = new Label("CURRENT TURN");
        currentT.setPrefWidth(160);
        currentT.setAlignment(Pos.CENTER);
        currentT.setStyle("-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:11pt;-fx-text-fill:#d8d8d8;");

        CurrentTurn.getChildren().addAll(currentT, CurrentPlayerTurn,Information);
        CurrentPlayerTurn.setStyle("-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:11pt;-fx-text-fill:#d8d8d8;");
        CurrentPlayerTurn.setPrefWidth(160);
        CurrentPlayerTurn.setAlignment(Pos.CENTER);


        VBox frame = new VBox(10);
        HBox leftBorder = new HBox();
        HBox rightBorder = new HBox();

        frame.getChildren().addAll(topFit, split, ScoreBoard, TurnsRemaining, CurrentTurn, bottomFit);
        topFit.setMinHeight(30);
        bottomFit.setMinHeight(30);

        frame.setAlignment(Pos.CENTER);
        frame.setPrefWidth(160);
        // this.getChildren().addAll(leftFit, pane1, rightFit);

        this.getChildren().addAll(leftBorder, frame, rightBorder);
        rightBorder.setMinWidth(60);
        leftBorder.setPrefWidth(30);
        rightFit.setPrefWidth(60);
        //    this.setPrefHeight(600);

    }

    public Label getScoreOfWhite() {
        return ScoreOfWhite;
    }

    public Label getScoreOfBlack() {
        return ScoreOfBlack;
    }

    public Label getRemainingTurns() {
        return RemainingTurns;
    }

    public Button getSplit() {
        return split;
    }

    public Label getCurrentPlayerTurn() {
        return CurrentPlayerTurn;
    }

    public Label getInformation() {
        return Information;
    }
}

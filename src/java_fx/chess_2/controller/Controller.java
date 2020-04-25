package java_fx.chess_2.controller;

import java_fx.chess_2.helper.Helper;
import java_fx.chess_2.model.GameModel;
import java_fx.chess_2.model.board.Tile;
import java_fx.chess_2.model.piece.*;
import java_fx.chess_2.view.MainPane;
import java_fx.chess_2.view.SplitDialog;
import java_fx.chess_2.view.TilePane;
import javafx.scene.Scene;
import javafx.scene.control.Dialog;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Controller implements ControllerImpl {

    private GameModel gameModel;
    private MainPane gameView;
    private int rows;
    private int cols;
    private Tile selectedTile;
    private int splitPieceIndex;

    public Controller(GameModel gameModel, MainPane gameView) {
        this.gameModel = gameModel;
        this.splitPieceIndex = -1;
        this.selectedTile = null;
        this.gameView = gameView;
        this.rows = gameView.getBoardPane().getTilePanes().length;
        this.cols = gameView.getBoardPane().getTilePanes()[0].length;
        redrawBoard();
        addTileHandler();
        addSplitHandler();
    }

    public Scene getScene() {
        Scene newScene = new Scene(gameView);
        newScene.getStylesheets().add("java_fx/chess_2/assets/styles/main.css");
        return newScene;
    }

    private void addSplitHandler() {
        this.gameView.getInfoPane().getSplitBtn().setOnAction(event -> {
            split();
        });
    }

    private void addTileHandler() {

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                TilePane tilePane = this.gameView.getBoardPane().getTilePanes()[i][j];
                tilePane.setOnAction(event -> {
                    System.out.println(tilePane.getRow()+";"+tilePane.getCol());
                    tileHandler2(tilePane.getRow(), tilePane.getCol());
                });
            }
        }
    }

    private void tileHandler2(int row, int col) {
        redrawBoard();
        if (this.gameModel.isGameOver()){
            new Dialog<>().show();
        }

        if (this.selectedTile == null) {
            Tile tile = this.gameModel.getBoard().getTiles()[row][col];
            if (tile.getPieceHolder().getPieceList().size() > 0&&
            this.gameModel.isPlayerOnesTurn()==tile.getPieceHolder().belongsPlayerOne()) {
                this.selectedTile = tile;
                drawCanGotoTiles(row,col);
            }else {
                this.selectedTile = null;
            }
        } else {
            if (splitPieceIndex != -1) {
                processSplitPieceAction(row, col);
            } else {
                processTileAction(row, col);
            }
        }
    }

    private void processTileAction(int row, int col) {
        if (!selectedTile.getPieceHolder().canGoto(selectedTile.getRow(),selectedTile.getCol(),row,col)){
            this.selectedTile = null;
            return;
        }
        if (selectedTile.getPieceHolder().belongsPlayerOne()==
                gameModel.getBoard().getTiles()[row][col]
                        .getPieceHolder().belongsPlayerOne()){
            gameModel.getBoard().getTiles()[row][col].getPieceHolder().mergeFrom(
                    selectedTile.getPieceHolder()
            );

        }else {
            gameModel.getBoard().getTiles()[row][col].getPieceHolder().clear();
            gameModel.getBoard().getTiles()[row][col].getPieceHolder().mergeFrom(
                    selectedTile.getPieceHolder()
            );

        } gameModel.getBoard().getTiles()[selectedTile.getRow()][selectedTile.getCol()].getPieceHolder().clear();
        gameModel.changeTurn();
        this.selectedTile = null;
        redrawBoard();
    }


    private void processSplitPieceAction(int row, int col) {
        if (this.gameModel.getBoard()
                .getTiles()[selectedTile.getRow()][selectedTile.getCol()]
                .canCoto(splitPieceIndex, row, col)) { // if can reach the target
            if (this.selectedTile
                    .getPieceHolder()
                    .belongsPlayerOne()
                    ==
                    this.gameModel.getBoard()
                            .getTiles()[row][col].getPieceHolder()
                            .belongsPlayerOne()) { // same player's piece, add the piece to new, remove it from old
                Piece piece = this.selectedTile.getPieceHolder()
                        .getPieceList().get(splitPieceIndex);
                this.gameModel.getBoard().getTiles()[row][col]
                        .getPieceHolder().add(piece);
                this.gameModel.getBoard()
                        .getTiles()[selectedTile.getRow()][selectedTile.getCol()]
                        .getPieceHolder().getPieceList().remove(splitPieceIndex);
            } else { // different players' pieces, clear the target tile, add the piece to target, remove it from origin
                Piece piece = this.selectedTile.getPieceHolder().getPieceList().get(splitPieceIndex);
                this.gameModel.getBoard().getTiles()[row][col].getPieceHolder().clear();
                this.gameModel.getBoard().getTiles()[row][col].getPieceHolder().add(piece);
                this.gameModel.getBoard()
                        .getTiles()[selectedTile.getRow()][selectedTile.getCol()]
                        .getPieceHolder().remove(splitPieceIndex);
            }
            this.gameModel.changeTurn();
            this.splitPieceIndex = -1;
            if (this.gameModel.isGameOver()) {
                showEnd();
            }
        } else { // cannot reach the target
            this.splitPieceIndex = -1;
        }
    }

    private void showEnd() {
        HBox hBox = new HBox();
        hBox.getChildren().add(new Text("Hey"));
        Stage stage = new Stage();
        stage.setScene(new Scene(hBox));
        stage.show();
    }

    private void tileHandler(int row, int col) {
        gameView.getInfoPane().getSplitBtn().setDisable(true);

        redrawBoard();
//        displayGameInfo();
        Tile tile = this.gameModel.getBoard().getTiles()[row][col];


        if (this.selectedTile == null) {

            if (tile.isEmpty()) {
                refreshGameInfo();
            } else {
                this.selectedTile = tile;

                if (selectedTile.getPieceHolder().belongsPlayerOne() != gameModel.isPlayerOnesTurn()) {
                    selectedTile = null;
                    return;
                }
                if (selectedTile.getPieceHolder().getPieceList().size() > 1) {
                    gameView.getInfoPane().getSplitBtn().setDisable(false);
                }
                refreshGameInfo();
                drawCanGotoTiles(row, col);
            }
        } else {

            if (selectedTile.getPieceHolder().belongsPlayerOne() != gameModel.isPlayerOnesTurn()) {
                selectedTile = null;
                refreshGameInfo();
                return;
            }
            if (selectedTile.getPieceHolder().canGoto(
                    selectedTile.getRow(),
                    selectedTile.getCol(),
                    row,
                    col
            )) {
                this.gameModel.move(
                        selectedTile.getRow(),
                        selectedTile.getCol(),
                        row,
                        col
                );

                this.selectedTile = null;
                this.gameModel.changeTurn();
                redrawBoard();
            } else {
                this.selectedTile = null;
                redrawBoard();
            }
        }
        refreshGameInfo();
        System.out.println(row + ";" + col);
//        displayGameInfo();
        if (this.gameModel.isGameOver()) {
            new Dialog().show();
        }
    }

    private void drawGanGotoTiles(int index) {
        Tile tile = new Tile(this.selectedTile.getRow(), this.selectedTile.getCol());
        tile.getPieceHolder().add(
                this.selectedTile.getPieceHolder().getPieceList().get(index));
        this.gameView.getBoardPane()
                .getTilePanes()[this.selectedTile.getRow()][this.selectedTile.getCol()].drawGreenBg();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (tile.canCoto(0, i, j)) {
                    this.gameView.getBoardPane().getTilePanes()[i][j].drawBlueBg();
                }
            }
        }
    }

    private void drawCanGotoTiles(int row_, int col_) {
        TilePane[][] tilesView = this.gameView.getBoardPane().getTilePanes();
        Tile[][] tilesModel = this.gameModel.getBoard().getTiles();
        PieceHolder pieceHolder = tilesModel[row_][col_].getPieceHolder();
        tilesView[row_][col_].drawGreenBg();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pieceHolder.canGoto(row_, col_, i, j)) {
                    tilesView[i][j].drawBlueBg();
                }
            }
        }
    }


    private void split() {
        List<TilePane> list = new ArrayList<>();
        for (Piece P : selectedTile.getPieceHolder().getPieceList()) {
            TilePane tilePane = new TilePane(80, 80);
            PieceHolder Ph = new PieceHolder();
            Ph.add(P);
            tilePane.drawIcon(Helper.iconURL(Ph));

            list.add(tilePane);
        }
        SplitDialog splitDialog = new SplitDialog(list);
        for (TilePane tilePane : splitDialog.getSplitPieces()) {
            tilePane.setOnAction(event -> {
                splitPieceIndex = splitDialog.getSplitPieces().indexOf(tilePane);
                drawGanGotoTiles(splitPieceIndex);
                splitDialog.close();
            });
        }
        splitDialog.show(); //TO TEST
    }

    private String pieceInfo() {
        if (this.selectedTile == null) {
            return "Not selectedTile";
        }
        String info = this.gameModel.isPlayerOnesTurn() ? "Selected Player One's " : "Selected Player Two's ";
        if (selectedTile.getPieceHolder().getPieceList().size() == 1) {
            Piece piece = selectedTile.getPieceHolder().getPieceList().get(0);
            if (piece instanceof Rook) info += "Rook";
            if (piece instanceof Knight) info += "Knight";
            if (piece instanceof Bishop) info += "Bishop";
        } else if (
                selectedTile.getPieceHolder().getPieceList().size() > 1
        ) {
            info += "Merged Piece";
        }
        return info;
    }

    private void refreshGameInfo() {
        int turns = this.gameModel.getTurns();
        int player1pieces = this.gameModel.countPiece(true);
        int player2pieces = this.gameModel.countPiece(false);
        String whoseTurn = this.gameModel.isPlayerOnesTurn() ? "Player One's Turn" : "Player Two's Turn";
        this.gameView.getInfoPane().getGameTurns().setText("Remaining turns: " + turns);
        this.gameView.getInfoPane().getWhoseTurn().setText(whoseTurn);
        this.gameView.getInfoPane().getGameInfo().setText(pieceInfo());
        this.gameView.getInfoPane().getPlayerOnePieces().setText("Player One Pieces: " + player1pieces);
        this.gameView.getInfoPane().getPlayerTwoPieces().setText("Player Two Pieces: " + player2pieces);
    }

    private void redrawBoard() {
        refreshGameInfo();
        TilePane[][] tilesView = this.gameView.getBoardPane().getTilePanes();
        Tile[][] tilesModel = this.gameModel.getBoard().getTiles();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tilesView[i][j].drawBg();
                if (!(tilesModel[i][j].isEmpty())) {
                    PieceHolder piece = tilesModel[i][j].getPieceHolder();
                    tilesView[i][j].drawIcon(Helper.iconURL(piece));
                } else {
                    tilesView[i][j].clearIcon();
                }
            }
        }
    }
}

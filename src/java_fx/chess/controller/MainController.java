package java_fx.chess.controller;

import java_fx.chess.model.gameboard.GameBoard;
import java_fx.chess.model.gameboard.Tile;
import java_fx.chess.model.piece.Piece;
import java_fx.chess.model.piece.Shark;
import java_fx.chess.model.utilities.PieceLevel;
import java_fx.chess.view.MainPane;
import java_fx.chess.view.TilePane;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;

public class MainController {
    private GameBoard model;
    private MainPane view;
    private int row = 8;
    private int col = 8;
    private Tile selected;

    public MainController(GameBoard model, MainPane view) {
        this.model = model;
        this.view = view;
        this.selected = null;
        reDrawBoard();
        displayGameInfo();
        addTileHandler(row, col); //

    }

    private void action() {

    }

    private void addTileHandler(int row, int col) {

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                TilePane tilePane = this.view.getBoardPane().getTilePanes()[i][j];
                tilePane.setOnAction(event -> {
                    tileHandler(tilePane.getRow(), tilePane.getCol());
                });
            }
        }
    }

    private void tileHandler(int row, int col) {
        reDrawBoard();
        displayGameInfo();
        Tile tile = this.model.getTiles()[row][col];


        if (this.selected == null) {
            if (tile.isEmpty()) {

            } else {
                this.selected = tile;
                drawCanGotoTiles(row, col);
            }
        } else {
            if (selected.getPiece().canGoto(
                    selected.getRow(),
                    selected.getCol(),
                    row,
                    col
            )) {
                this.model.move(
                        selected.getRow(),
                        selected.getCol(),
                        row,
                        col
                );

                this.selected = null;
                reDrawBoard();
            } else {
                this.selected = null;
                reDrawBoard();
            }
        }

        displayGameInfo();

//        if (tile.isEmpty()) {
//            if (this.selected == null) {
//
//            }
//        } else {
//            if (this.selected != null) {
//
//            }
//        }
    }


    public Scene getView() {
        Scene scene = new Scene(view);
        scene.getStylesheets().add("java_fx/chess/view/assets/css/style.css");
        return scene;
    }

    private void drawCanGotoTiles(int row_, int col_) {
        TilePane[][] tilesView = this.view.getBoardPane().getTilePanes();
        Tile[][] tilesModel = this.model.getTiles();
        Piece piece = tilesModel[row_][col_].getPiece();
        tilesView[row_][col_].drawGreenBg();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (piece.canGoto(row_, col_, i, j)) {
                    tilesView[i][j].drawBlueBg();
                }
            }
        }
    }

    private void reDrawBoard() {
        TilePane[][] tilesView = this.view.getBoardPane().getTilePanes();
        Tile[][] tilesModel = this.model.getTiles();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                tilesView[i][j].drawBg();
                if (!(tilesModel[i][j].isEmpty())) {
                    Piece piece = tilesModel[i][j].getPiece();
                    tilesView[i][j].drawIcon(getPieceImageURL(piece));
                } else {
                    tilesView[i][j].clearIcon();
                    tilesView[i][j].setTooltip(new Tooltip("Please click piece to move!"));
                }
            }
        }
    }

    private void displayGameInfo() {
        String currentPlay = this.selected == null ? "Not selected" : selected.getPiece() + "\n" +
                "at (" + selected.getRow() + "," + selected.getCol() + ")";
        this.view.getInfoPane().getCurrentPlayerTurn().setText(currentPlay);
        this.view.getInfoPane().getInformation().setText(this.model.gameInfo());
        System.out.println(this.model.gameInfo());
    }

    private String getPieceImageURL(Piece piece) {
        String URL = "java_fx/chess/view/assets/images/";
        StringBuilder sb = new StringBuilder();
        if (piece instanceof Shark) {
            sb.append(URL);
            sb.append("b");
            sb.append(levelStringURL(piece.getPieceLevel()));
        } else {
            sb.append(URL);
            sb.append("w");
            sb.append(levelStringURL(piece.getPieceLevel()));
        }
        return sb.toString();
    }

    private String levelStringURL(PieceLevel pieceLevel) {
        switch (pieceLevel) {
            case BABY:
                return "_rook.png";
            case MEDIUM:
                return "_bishop.png";
            case BIG:
                return "_merge.png";
            case SMALL:
                return "_knight.png";
            default:
                return "_rook.png";
        }
    }
}

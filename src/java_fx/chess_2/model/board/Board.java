package java_fx.chess_2.model.board;

import java_fx.chess_2.model.piece.Bishop;
import java_fx.chess_2.model.piece.Knight;
import java_fx.chess_2.model.piece.Piece;
import java_fx.chess_2.model.piece.Rook;

public class Board {
    private Tile[][] tiles;

    public Board(int rows, int cols) {

        setupBoard(rows, cols);
        setupPiecesOnBoard(rows, cols);
    }

    private void addPiece(int i,int lastRow,Piece piece1, Piece piece2){
        tiles[0][i].getPieceHolder().add(piece1);
        tiles[lastRow][i].getPieceHolder().add(piece2);

    }

    private void setupPiecesOnBoard(int rows, int cols) {
        int lastRow = rows - 1;
        for (int i = 0; i < cols; i++) {
            if(i==0|| i==7){
                addPiece(i,lastRow,new Rook(true), new Rook(false));
            }
            if (i == 1 || i == 6) {
                addPiece(i,lastRow, new Knight(true),new Knight(false));
            }
            if (i == 2 || i == 5) {
                addPiece(i,lastRow,new Bishop(true), new Bishop(false));
            }
//            if (i == 3 || i == 4) {
//
//            }
        }
    }

    private void setupBoard(int rows, int cols) {
        this.tiles = new Tile[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tiles[i][j] = new Tile(i, j);
            }
        }
    }


    public Tile[][] getTiles() {
        return tiles;
    }


}

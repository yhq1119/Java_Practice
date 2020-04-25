package java_fx.chess.model.gameboard;

import java_fx.chess.model.piece.Piece;

public class Tile {
    private Piece piece;
    private final int row;
    private final int col;

    public Tile(int row, int col) {
        this.row = row;
        this.col = col;
        this.piece = null;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isEmpty() {
        return this.piece == null;
    }

    public void clear() {
        this.piece = null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean equals(Tile coordinate) {
        return this.row == coordinate.getRow() && this.col == coordinate.getCol();
    }
}

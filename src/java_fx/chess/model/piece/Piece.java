package java_fx.chess.model.piece;

import java_fx.chess.model.utilities.PieceLevel;
import java_fx.chess.model.utilities.PieceStatus;

public abstract class Piece implements PieceInterface {

    protected PieceLevel pieceLevel;
    protected PieceStatus pieceStatus;

    public Piece(PieceLevel pieceLevel) {
        this.pieceLevel = pieceLevel;
    }

    public PieceLevel getPieceLevel() {
        return this.pieceLevel;
    }

    public void setPieceLevel(PieceLevel pieceLevel) {
        this.pieceLevel = pieceLevel;
    }

    public String toString() {
        return this.pieceLevel + " " + this.getClass().getName();
    }

    public boolean isNormal() {
        return this.pieceStatus.equals(PieceStatus.NORMAL);
    }

    public boolean isFrozen() {
        return this.pieceStatus.equals(PieceStatus.FROZEN);
    }

    public boolean isSlowed() {
        return this.pieceStatus.equals(PieceStatus.SLOWED);
    }

}

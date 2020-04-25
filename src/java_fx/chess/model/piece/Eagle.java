package java_fx.chess.model.piece;

import java_fx.chess.model.utilities.PieceLevel;

public class Eagle  extends Piece{
    public Eagle(PieceLevel pieceLevel) {
        super(pieceLevel);
    }

    @Override
    public boolean canGoto(int startRow, int startCol, int endRow, int endCol) {
        int deltaR = Math.abs(startRow - endRow);
        int deltaC = Math.abs(startCol - endCol);
        if (deltaR == deltaC) {
            return deltaR == 2 || deltaR == 1;
        }
        return false;
    }

    @Override
    public boolean canKill(Piece target) {
        return false;
    }

    @Override
    public boolean canMerge(Piece target) {
        return false;
    }

    @Override
    public boolean canCastSpell(Piece target) {
        return false;
    }

    @Override
    public void castSpell(Piece target) {

    }
}

package java_fx.chess.model.piece;

import java_fx.chess.model.utilities.PieceLevel;

public class Shark extends Piece {

    public Shark(PieceLevel pieceLevel) {
        super(pieceLevel);
    }

    @Override
    public boolean canGoto(int startRow, int startCol, int endRow, int endCol) {
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

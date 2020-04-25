package java_fx.chess.model.piece;

public interface PieceInterface {
    // Noticed that the piece methods are for setting up movement/capture rules
    // Actual actions will take place only on the board.

    public abstract boolean canGoto(int startRow, int startCol, int endRow, int endCol);

    // this checks if this piece can kill that piece
    public abstract boolean canKill(Piece target);

    public abstract boolean canMerge(Piece target);

    public abstract boolean canCastSpell(Piece target);

    // change status of target piece here
    public abstract void castSpell(Piece target);

    // public abstract void setPieceStatus(PieceStatus pieceStatus);



}

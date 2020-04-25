package java_fx.chess_2.model.piece;

public interface PieceImpl {
    // Noticed that the piece methods are for setting up movement/capture rules
    // Actual actions will take place only on the board.

    public abstract boolean canGoto(int startRow, int startCol, int endRow, int endCol);
//    public abstract Node[] canGoto(int startRow, int startCol);

    // this checks if this piece can kill that piece
    //    public abstract boolean canKill(Piece target);

    //    public abstract boolean canMerge(Piece target);

    // change status of target piece here
    //    public abstract void castSpell(Piece target);

    // public abstract void setPieceStatus(PieceStatus pieceStatus);


}

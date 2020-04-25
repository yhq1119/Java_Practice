package java_fx.chess.model.utilities;

public enum PieceStatus {
    NORMAL, // absolutely normal
    SLOWED, // this means the move range would reduce
    FROZEN // cannot move for one turn
}

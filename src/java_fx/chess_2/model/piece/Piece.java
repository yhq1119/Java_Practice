package java_fx.chess_2.model.piece;

public abstract class Piece implements PieceImpl  {
    private final boolean belongsPlayerOne;

    protected Piece(boolean belongsPlayerOne) {
        this.belongsPlayerOne = belongsPlayerOne;
    }

    public boolean isBelongsPlayerOne() {
        return belongsPlayerOne;
    }
}

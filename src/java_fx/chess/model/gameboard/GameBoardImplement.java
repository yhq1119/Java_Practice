package java_fx.chess.model.gameboard;

public interface GameBoardImplement {

    public abstract void move(int startRow, int startCol, int endRow, int endCol);
    public abstract void performKill(int startRow, int startCol, int endRow, int endCol);
    public abstract void castSpell(int startRow, int startCol, int endRow, int endCol);
    public abstract void turnSwap();
    public abstract String gameInfo();
}

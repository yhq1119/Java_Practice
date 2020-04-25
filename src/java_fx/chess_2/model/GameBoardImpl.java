package java_fx.chess_2.model;

public interface GameBoardImpl {

//    public int playerOneScore();
//    public int playerTwoScore();
    public  abstract  void changeTurn();
    public abstract  boolean isGameOver();
    public abstract void resetGame(int turns);
    public  abstract  int countPiece(boolean belongPlayerOne);
    public  abstract  void  move(int startRow, int startCol, int endRow, int endCol);

}

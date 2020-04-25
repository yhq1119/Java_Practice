package java_fx.chess_2.model;

import java_fx.chess_2.model.board.Board;
import java_fx.chess_2.model.board.Tile;
import java_fx.chess_2.model.piece.Piece;
import java_fx.chess_2.model.player.Player;

public class GameModel implements GameBoardImpl {

    private int rows;
    private int cols;
    private Board board;

    private Player playerOne;
    private Player playerTwo;
    private int turns;
    private boolean isPlayerOnesTurn;

    public GameModel(
            int turns,
            int rows, int cols,
            Player playerOne,
            Player playerTwo,
            boolean isPlayerOnesTurn) {
        this.rows = rows;
        this.cols = cols;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.turns = turns;
        this.isPlayerOnesTurn = isPlayerOnesTurn;
        setup();
    }

    private void setup() {
        this.board = new Board(rows, cols);
    }

    @Override
    public void resetGame(int turns) {

    }

    @Override
    public void changeTurn() {
        this.isPlayerOnesTurn = !this.isPlayerOnesTurn;
        this.turns--;
    }

    @Override
    public boolean isGameOver() {

        return getTurns()<1||countPiece(true)<1||countPiece(false)<1;
    }

    @Override
    public int countPiece(boolean belongPlayerOne) {
        int count = 0;
        for (Tile[] Ts : board.getTiles()) {
            for (Tile T : Ts) {
                if (!T.isEmpty()) {
                    for (Piece P : T.getPieceHolder().getPieceList()) {
                        if (P.isBelongsPlayerOne() == belongPlayerOne) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    @Override
    public void move(int startRow, int startCol, int endRow, int endCol) {

        if (!getTile(endRow,endCol).isEmpty()){
            if (getTile(endRow,endCol).getPieceHolder().belongsPlayerOne()
            ==
            getTile(startRow,startCol).getPieceHolder().belongsPlayerOne()){
                board.getTiles()[endRow][endCol].getPieceHolder().mergeFrom(
                        board.getTiles()[startRow][startCol].getPieceHolder());
                board.getTiles()[startRow][startCol].getPieceHolder().clear();
            }else {
                board.getTiles()[endRow][endCol].setPieceHolder(board.getTiles()[startRow][startCol].getPieceHolder());
                board.getTiles()[startRow][startCol].getPieceHolder().clear();
                if (isPlayerOnesTurn()){
                    playerOne.addScore();
                }
            }
        }else{
            board.getTiles()[endRow][endCol].setPieceHolder(board.getTiles()[startRow][startCol].getPieceHolder());
            board.getTiles()[startRow][startCol].getPieceHolder().clear();
        }
    }

    private Tile getTile(int row, int col) {
        return board.getTiles()[row][col];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public int getTurns() {
        return turns;
    }

    public boolean isPlayerOnesTurn() {
        return isPlayerOnesTurn;
    }
}

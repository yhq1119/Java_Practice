package java_fx.chess.model.gameboard;

import java_fx.chess.model.Player;
import java_fx.chess.model.piece.Eagle;
import java_fx.chess.model.piece.Piece;
import java_fx.chess.model.piece.Shark;
import java_fx.chess.model.utilities.PieceLevel;

public class GameBoard implements GameBoardImplement {

    private Player playerOne;
    private Player playerTwo;
    private Tile[][] tiles;
    private int gameTurns;
    private boolean isPlayerOnesTurn;
    private boolean isPlayerOneUseShark;

    private int board_rows = 8;
    private int board_cols = 8;

    public boolean hasEnded() {
        return gameTurns < 1
                ||
                countPieces(new Shark(PieceLevel.BABY)) == 0
                ||
                countPieces(new Eagle(PieceLevel.BABY)) == 0;
    }

    private int countPieces(Piece piece) {
        int count = 0;
        for (Tile[] Ts : tiles) {
            for (Tile T : Ts) {
                if (T.isEmpty()) {

                } else {
                    if (T.getPiece().getClass().equals(piece.getClass())) {
                        count++;
                    }
                }

            }
        }
        return count;
    }

    public void swapTurn() {
        isPlayerOnesTurn = !isPlayerOnesTurn;
        gameTurns--;
    }

    public GameBoard(
            String playerOneName,
            String playerTwoName,
            int gameTurns,
            boolean isPlayerOnesTurn,
            boolean isPlayerOneUseShark
    ) {
        this.playerOne = new Player(playerOneName);
        this.playerTwo = new Player(playerTwoName);
        this.gameTurns = gameTurns;
        this.isPlayerOnesTurn = isPlayerOnesTurn;
        this.isPlayerOneUseShark = isPlayerOneUseShark;
        initializeBoard();
        initializePiecesOnBoard();
    }

    private void initializePiecesOnBoard() {
        int lastRow = board_rows - 1;
        for (int i = 0; i < board_cols; i++) {
            tiles[0][i].setPiece(new Shark(PieceLevel.BABY));
            tiles[lastRow][i].setPiece(new Eagle(PieceLevel.BABY));
            if (i == 1 || i == 6) {
                tiles[0][i].getPiece().setPieceLevel(PieceLevel.SMALL);
                tiles[lastRow][i].getPiece().setPieceLevel(PieceLevel.SMALL);
            }
            if (i == 2 || i == 5) {
                tiles[0][i].getPiece().setPieceLevel(PieceLevel.MEDIUM);
                tiles[lastRow][i].getPiece().setPieceLevel(PieceLevel.MEDIUM);
            }
            if (i == 3 || i == 4) {
                tiles[0][i].getPiece().setPieceLevel(PieceLevel.BIG);
                tiles[lastRow][i].getPiece().setPieceLevel(PieceLevel.BIG);
            }
        }
    }

    private void initializeBoard() {
        tiles = new Tile[board_rows][board_cols];
        for (int i = 0; i < board_rows; i++) {
            for (int j = 0; j < board_cols; j++) {
                tiles[i][j] = new Tile(i, j);
            }
        }

    }


    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public int getGameTurns() {
        return gameTurns;
    }

    public boolean isPlayerOnesTurn() {
        return isPlayerOnesTurn;
    }


    @Override
    public void move(int startRow, int startCol, int endRow, int endCol) {
        tiles[endRow][endCol].clear();
        tiles[endRow][endCol].setPiece(tiles[startRow][startCol].getPiece());
        tiles[startRow][startCol].clear();
    }

    @Override
    public void performKill(int startRow, int startCol, int endRow, int endCol) {
        move(startRow, startCol, endRow, endCol);

    }

    @Override
    public void castSpell(int startRow, int startCol, int endRow, int endCol) {

    }

    @Override
    public void turnSwap() {

    }

    @Override
    public String gameInfo() {
        String remainTurn = "Remaining turns=" + gameTurns;
        String belongs = isPlayerOneUseShark ? "Player One using Shark" : "Player Two using Shark";
        String current = isPlayerOnesTurn ? "Player One's turn" : "Player Two's turn";

        return piecesInfo() + "\n" + remainTurn + "\n" + belongs + "\n" + current + "\n" + playerInfo();
    }

    private String piecesInfo() {
        return "Shark pieces=[" + countPieces(new Shark(PieceLevel.BABY)) + "]\n" +
                "Eagle pieces=[" + countPieces(new Eagle(PieceLevel.BABY)) + "]\n";
    }

    private String playerInfo() {
        String info = "Player One info=" + playerOne +
                "\n" +
                "Player Two info=" + playerTwo +
                "\n";
        return info;
    }


}

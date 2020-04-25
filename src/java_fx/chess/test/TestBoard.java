package java_fx.chess.test;

import java_fx.chess.model.gameboard.Tile;
import java_fx.chess.model.piece.Eagle;
import java_fx.chess.model.piece.Piece;
import java_fx.chess.model.piece.Shark;
import java_fx.chess.model.utilities.PieceLevel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestBoard {

    private List<Piece> pieceList;
    private Piece[] pieceArray;
    private Tile[][] boardTiles;
    private PieceLevel baby;
    private PieceLevel small;
    private PieceLevel medium;
    private PieceLevel big;

    @Test
    void testGetClass(){
        Shark C = new Shark(medium);
        C.setPieceLevel(null);
        Shark A = new Shark(baby);
        Shark B = new Shark(big);
        System.out.println(A.getClass());
        System.out.println(B.getClass());
        System.out.println(C.getClass());
        System.out.println(A.getClass().equals(B.getClass()));
        System.out.println(A.getClass()==B.getClass());
    }

    @Test
    void testPieceReferencing(){
        pieceList = new ArrayList<>();
        pieceList.add(new Shark(baby));
        pieceList.add(new Shark(small));
        pieceList.add(new Shark(medium));
        pieceList.add(new Shark(big));

        pieceArray = new Piece[4];
        pieceArray[0] = new Eagle(baby);
        pieceArray[1] = new Eagle(small);
        pieceArray[2] = new Eagle(medium);
        pieceArray[3] = new Eagle(big);

        int row = 8;
        int col = 8;
        boardTiles = new Tile[row][col];
        for (int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                boardTiles[i][j] = new Tile(i,j);
                if (i==0&&j<4){
                    boardTiles[i][j].setPiece(pieceList.get(j));
                }
                if(i==7&&j<4){
                    boardTiles[i][j].setPiece(pieceArray[j]);
                }
            }
        }

        showBoard();
        boardTiles[0][0].clear();
        System.out.println(pieceList.get(0));
    }

    private void showBoard(){
        for (Tile[] Ts: boardTiles){
            for(Tile T: Ts){
                if (T.isEmpty()){
                    System.out.print("  .  ");
                }
                else {
                    if (T.getPiece() instanceof  Shark) System.out.print(" S ");
                    if (T.getPiece() instanceof  Eagle) System.out.print(" E ");
                }
            }
            System.out.println();
        }
    }
}

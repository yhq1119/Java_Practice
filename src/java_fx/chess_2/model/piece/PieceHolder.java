package java_fx.chess_2.model.piece;

import java.util.ArrayList;
import java.util.List;

public class PieceHolder  {

    private List<Piece> pieceList;

    public PieceHolder() {
        this.pieceList = new ArrayList<>();
    }

    public void add(Piece piece){
        pieceList.add(piece);
    }

    public void mergeFrom(PieceHolder pieceHolder){
        for (Piece piece : pieceHolder.getPieceList()){
            add(piece);
        }
    }

    public void remove(int index){
        pieceList.remove(index);
    }

    public Piece pop(int index){
        return pieceList.get(index);
    }

    public void clear(){
        this.pieceList = new ArrayList<>();
    }

    public boolean belongsPlayerOne(){
        for (Piece P : pieceList){
            if (!P.isBelongsPlayerOne()){
                return false;
            }
        }
        return true;
    }

    public  boolean canGoto(int startRow, int startCol, int endRow, int endCol){
        for (Piece P:pieceList){
            if (P.canGoto(startRow,startCol, endRow, endCol)){
                return true;
            }
        }
        return false;
    }

    public List<Piece> getPieceList() {
        return pieceList;
    }
}

package java_fx.chess_2.model.board;

import java_fx.chess_2.model.piece.PieceHolder;

public class Tile {
    private PieceHolder pieceHolder;
    private final int row;
    private final int col;

    public Tile(int row, int col) {
        this.row = row;
        this.col = col;
        this.pieceHolder = new PieceHolder();
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isEmpty() {
        return this.pieceHolder == null
                ||
                this.pieceHolder.getPieceList().size() < 1;
    }

    public void setPieceHolder(PieceHolder pieceHolder){
        this.getPieceHolder().clear();
        this.pieceHolder = pieceHolder;
    }

    public PieceHolder getPieceHolder() {
        return pieceHolder;
    }

//    public boolean sameLocation(Tile coordinate) {
//        return this.row == coordinate.getRow()
//                &&
//                this.col == coordinate.getCol();
//    }

    public boolean canGoto(int row, int col){
        return this.getPieceHolder().canGoto(this.getRow(),this.getCol(),row,col);
    }
    public boolean canCoto(int index, int row, int col){
        return this.getPieceHolder().getPieceList().get(index)
                .canGoto(this.getRow(),this.getCol(),row,col);
    }
}

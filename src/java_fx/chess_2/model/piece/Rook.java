package java_fx.chess_2.model.piece;

public class Rook extends Piece {
    public Rook(boolean belongsPlayerOne) {
        super(belongsPlayerOne);
    }

    @Override
    public boolean canGoto(int startRow, int startCol, int endRow, int endCol) {

        int deltaC = Math.abs(startCol - endCol);
        int deltaR = Math.abs(startRow - endRow);
        if (deltaC == 0 || deltaR == 0) {
            return deltaC == 2 || deltaC == 1 || deltaR == 2 || deltaR == 1;
        }
        return false;
    }
//    @Override
//    public Node[] canGoto(int row, int col) {
//        Node[] nodes = new Node[8];
//        nodes[0] = new Node(row-2,col);
//        nodes[1] = new Node(row-1,col);
//        nodes[2] = new Node(row,col-2);
//        nodes[3] = new Node(row,col-1);
//        nodes[4] = new Node(row,col+1);
//        nodes[5] = new Node(row,col+2);
//        nodes[6] = new Node(row+1,col);
//        nodes[7] = new Node(row+2,col);
//        return new Node[0];
//    }

}

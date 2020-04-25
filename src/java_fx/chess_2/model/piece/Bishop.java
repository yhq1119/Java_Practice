package java_fx.chess_2.model.piece;

public class Bishop extends Piece{
    public Bishop(boolean belongsPlayerOne) {
        super(belongsPlayerOne);
    }

    @Override
    public boolean canGoto(int startRow, int startCol, int endRow, int endCol) {
        int deltaR = Math.abs(startRow - endRow);
        int deltaC = Math.abs(startCol - endCol);
        if (deltaR == deltaC) {
            return deltaR == 2 || deltaR == 1;
        }
        return false;
    }
//    @Override
//    public Node[] canGoto(int row, int col) {
//        Node[] nodes = new Node[8];
//        nodes[0] = new Node(row-2,col-2);
//        nodes[1] = new Node(row-2,col+2);
//        nodes[2] = new Node(row-1,col-1);
//        nodes[3] = new Node(row-1,col+1);
//        nodes[4] = new Node(row+1,col-1);
//        nodes[5] = new Node(row+1,col+1);
//        nodes[6] = new Node(row+2,col-2);
//        nodes[7] = new Node(row+2,col+2);
//        return new Node[0];
//    }

}

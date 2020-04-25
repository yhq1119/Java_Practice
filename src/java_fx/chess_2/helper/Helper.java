package java_fx.chess_2.helper;

import java_fx.chess_2.model.piece.*;

public class Helper {

    public static String iconURL(PieceHolder pieceHolder) {
        String URL = "java_fx/chess_2/assets/images/";
        StringBuilder sb = new StringBuilder();
        sb.append(URL);
        if (pieceHolder.belongsPlayerOne()) {
            sb.append("b_");
        } else {
            sb.append("w_");
        }
        if (pieceHolder.getPieceList().size() < 1) {

        } else if (pieceHolder.getPieceList().size() == 1) {
            Piece piece = pieceHolder.getPieceList().get(0);
            if (piece instanceof Rook) sb.append("rook.png");
            if (piece instanceof Bishop) sb.append("bishop.png");
            if (piece instanceof Knight) sb.append("knight.png");
        } else {
            sb.append("merge.png");
        }
        return sb.toString();
    }
}


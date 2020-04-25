package java_fx.chess.view;

import javafx.scene.layout.GridPane;

public class BoardPane extends GridPane {

    private TilePane[][] tilePanes;
    private double Vgap = 8;
    private double Hgap = 8;
    private double tileHeight = 80;
    private double tileWidth = 80;

    public BoardPane(int row, int col) {
        super();
        this.tilePanes = new TilePane[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                tilePanes[i][j] = new TilePane(i, j);
                tilePanes[i][j].setupSize(tileHeight, tileWidth);
                this.add(tilePanes[i][j], j, i);
            }
        }

        this.setVgap(Vgap);
        this.setHgap(Hgap);
    }

    public TilePane[][] getTilePanes() {
        return tilePanes;
    }
}

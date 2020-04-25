package java_fx.chess_2.view;

import javafx.scene.layout.GridPane;

public class BoardPane extends GridPane {

    private final int rows;
    private final int cols;
    private TilePane[][] tilePanes;

    private double Vgap = 8;
    private double Hgap = 8;
    private double tileHeight = 80;
    private double tileWidth = 80;

    public BoardPane(int rows, int cols) {
        super();
        this.rows = rows;
        this.cols = cols;
        setup();
    }

    private void setup() {
        tilePanes = new TilePane[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tilePanes[i][j] = new TilePane(i, j);
                tilePanes[i][j].setupSize(tileHeight, tileWidth);
                this.add(tilePanes[i][j], j, i);
            }
        }
        this.setVgap(Vgap);
        this.setHgap(Hgap);
        this.setStyle("-fx-border-radius:15");
    }

    public TilePane[][] getTilePanes() {
        return tilePanes;
    }
}

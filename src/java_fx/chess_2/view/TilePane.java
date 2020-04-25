package java_fx.chess_2.view;

import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;

public class TilePane extends Button {

    private final int row;
    private final int col;

    public TilePane(int row, int col) {
        this.row = row;
        this.col = col;
        this.setStyle("-fx-opacity:0.5 ;-fx-background-radius:40");
        this.setBorder(Border.EMPTY);
        this.setTooltip(new Tooltip("click piece to move"));
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setupSize(double height, double width) {
        this.setPrefHeight(height);
        this.setPrefWidth(width);
        this.setMinSize(width, height);
        this.setMaxSize(width, height);
        double size = (height + width) ;
        this.setStyle("-fx-border-radius:"+size+";");
    }

    public void drawBg() {
        this.setStyle("-fx-background-color: #0066af");
    }

    public void drawGreenBg(){
        this.setStyle("-fx-background-color: #558bcc");
    }

    public void drawRedBg(){
        this.setStyle("-fx-background-color: RED");
    }

    public void drawBlueBg(){
        this.setStyle("-fx-background-color: #1ab9d1");
    }

    public void drawIcon(String iconURL) {
        this.setGraphic(new ImageView(iconURL));
        this.setContentDisplay(ContentDisplay.CENTER);
    }

    public void clearIcon() {
        this.setGraphic(null);
    }

}

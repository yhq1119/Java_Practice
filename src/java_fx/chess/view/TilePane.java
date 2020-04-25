package java_fx.chess.view;

import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.ImageView;

public class TilePane extends Button {
    private final int row;
    private final int col;

    public TilePane(int row, int col) {
        this.row = row;
        this.col = col;
        this.setStyle("-fx-opacity:0.75 ;-fx-background-radius:40");
//        drawBg();
    }

    public void drawBg(){
//        if ((row+col)%2==0){
            this.setStyle("-fx-background-color: darkgrey");
//        }else {
//            this.setStyle("-fx-background-color: darkslategray");
//        }
    }

    public void setupSize(double height, double width){
        this.setPrefHeight(height);
        this.setPrefWidth(width);
        this.setMinSize(width,height);
        this.setMaxSize(width,height);

    }

    public void drawGreenBg(){
        this.setStyle("-fx-background-color: GREEN");
    }

    public void drawRedBg(){
        this.setStyle("-fx-background-color: RED");
    }


    public void drawBlueBg(){
        this.setStyle("-fx-background-color: BLUE");
    }


    public void drawIcon(String iconURL) {
        this.setGraphic(new ImageView(iconURL));
        this.setContentDisplay(ContentDisplay.CENTER);
    }

    public void clearIcon() {
        this.setGraphic(null);
    }
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

}

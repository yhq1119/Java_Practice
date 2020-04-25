package java_fx.chess_2.view;

import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class SplitDialog extends Stage {

    private List<TilePane> splitPieces;

    private double tileHeight = 80;
    private double tileWidth = 80;

    public SplitDialog(List<TilePane> splitPieces) {
        VBox panel = new VBox();
        HBox topFill = new HBox();
        HBox bottomFill = new HBox();

        VBox leftFill = new VBox();
        VBox rightFill = new VBox();
        HBox container = new HBox();

        FlowPane flowPane = new FlowPane();

        this.splitPieces = splitPieces;
        for(TilePane tilePane:splitPieces){
           tilePane.setupSize(tileHeight, tileWidth);
            flowPane.getChildren().add(tilePane);
        }

        container.getChildren().addAll(leftFill,flowPane,rightFill);
        panel.getChildren().addAll(topFill,container,bottomFill);
        this.setScene(new Scene(panel));
    }

    public List<TilePane> getSplitPieces() {
        return splitPieces;
    }
}

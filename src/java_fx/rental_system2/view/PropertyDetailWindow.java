package java_fx.rental_system2.view;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class PropertyDetailWindow extends Stage {
    private Label id;
    private Label address;
    private Label rooms;
    private Label price;
    private Label penalty;

    public PropertyDetailWindow(
            String id,
            String address,
            int rooms,
            double price,
            double penalty
    ) {
        this.id= new Label(id);
        this.address = new Label(address);
        this.rooms = new Label(String.valueOf(rooms));
        this.price = new Label(String.valueOf(price));
        this.price = new Label(String.valueOf(penalty));
    }

    private void setup(){
        HBox root = new HBox();
        VBox left = new VBox();
        VBox right = new VBox();
        ImageView imageView = new ImageView(new Image(""));
        left.getChildren().addAll(imageView,new Label("test1"),new Label("test2"));
    }
}

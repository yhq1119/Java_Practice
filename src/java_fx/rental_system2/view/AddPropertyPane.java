package java_fx.rental_system2.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class AddPropertyPane extends VBox {
    TextField id_Input;
    TextField address_Input;
    TextField room_Input;
    TextField price_Input;
    Button add;

    public AddPropertyPane() {
        id_Input = new TextField();
        address_Input = new TextField();
        room_Input = new TextField();
        price_Input = new TextField();
        add = new Button("Add");
        setup();
    }

    private void setup(){
        Label id_hint  = new Label("Please input ID");
        Label address_hint  = new Label("Address");
        Label room_hint  = new Label("Rooms");
        Label price_hint  = new Label("Price");
        this.getChildren().addAll(
                id_hint,id_Input,
                address_hint,address_Input,
                room_hint,room_Input,
                price_hint,price_Input,add);
    }
}

package java_fx.rental_system2.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

public class MainViewPane extends HBox {

    private Text text;
    private Button search;
    private Button addnew;
    private Button clear;
    private FlowPane content;

    public MainViewPane() {
        super();
        initialize();
        setup();
    }

    private void initialize() {
        text = new Text("Not set");
        search = new Button("Search");
        addnew = new Button("Add Property");
        clear = new Button("Clear");
        content = new FlowPane();
        this.getChildren().addAll(content,addnew, search, clear);
    }

    private void setup() {
        this.setHeight(600);
        this.setWidth(1000);
        addnew.setOnAction(event -> {
           Stage stage =  new Stage();
           stage.setScene(new Scene(new AddPropertyPane()));
           stage.show();
        });
    }

    public Text getText() {
        return text;
    }

    public Button getSearch() {
        return search;
    }

    public Button getClear() {
        return clear;
    }

    public FlowPane getContentPane() {
        return content;
    }
}

package java_fx.chess_2.view;

import javafx.animation.PathTransition;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class MoveAnimation  {
    public static void play(TilePane origin, TilePane end){
        Path path = new Path();
        path.getElements().add(new MoveTo(end.getLayoutX(),end.getLayoutY()));
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(350));
        pathTransition.setPath(path);
        pathTransition.setNode(origin);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(1);
        pathTransition.play();
    }
}

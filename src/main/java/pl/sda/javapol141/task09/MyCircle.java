package pl.sda.javapol141.task09;

import javafx.geometry.Point2D;
import javafx.scene.shape.Circle;

public class MyCircle extends Circle {
    public MyCircle(Point2D center, Point2D point) {
        super(
                center.getX(),
                center.getY(),
                Math.sqrt(
                        (center.getX() - point.getX()) * (center.getX() - point.getX())
                                + (center.getY() - point.getY()) * (center.getY() - point.getY()))
        );
    }
}

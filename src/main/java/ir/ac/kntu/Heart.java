/**
 * represents a heart which is a subclass to random elements
 * this will adds up 20 to spaceships health
 */

package ir.ac.kntu;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.awt.*;

public class Heart extends RandomElements {
    public Heart(int x, int y) {
        super(x, y, new Image("C:\\Users\\SONY\\Desktop\\temp\\p3-space-invaders\\src\\main\\resources\\assets\\heart.png"));
    }
}

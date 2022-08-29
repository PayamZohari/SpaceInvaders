/**
 * this is a subclass to random elements
 * this will able spaceship to destroy any alien in its line
 */
package ir.ac.kntu;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Lasergun extends RandomElements {
    public Lasergun(int x, int y) {
        super(x, y, new Image("C:\\Users\\SONY\\Desktop\\temp\\p3-space-invaders\\src\\main\\resources\\assets\\lasergun.png"));
    }
}

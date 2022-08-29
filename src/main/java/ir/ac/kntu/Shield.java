/**
 * this is a random element too so its a subclass to it
 * it can save spaceship from shots for 7 seconds
 */
package ir.ac.kntu;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Shield extends RandomElements {
    public Shield(int x, int y) {
        super(x, y, new Image("C:\\Users\\SONY\\Desktop\\temp\\p3-space-invaders\\src\\main\\resources\\assets\\shield.png"));
    }
}

/**
 * this class is also a subclass to aliens and they are stronger kind of aliens
 * more destructive and less volnurable and they can find where spaceship is and shoot precicely
 * through it's direction
 */
package ir.ac.kntu;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.awt.*;

public class SecondaryAlien extends Alien {
    public SecondaryAlien(int x, int y) {
        super(x, y, new Image("C:\\Users\\SONY\\Desktop\\temp\\p3-space-invaders\\src\\main\\resources\\assets\\alien_two_white.png"));
    }

}

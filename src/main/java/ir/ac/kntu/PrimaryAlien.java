/**
 * these are first kind of aliens have less power , give less scores to spaceship
 * they only can shoot up to down and their shots are less destructive
 */

package ir.ac.kntu;

import javafx.scene.ImageCursor;
import javafx.scene.image.Image;

import java.awt.*;

public class PrimaryAlien extends Alien {
    public PrimaryAlien(int x, int y) {
        super(x, y, new Image("C:\\Users\\SONY\\Desktop\\Zohari-SpaceInvadersProject\\p3-space-invaders\\src\\main\\resources\\assets\\alien_one_white.png"));
    }
}

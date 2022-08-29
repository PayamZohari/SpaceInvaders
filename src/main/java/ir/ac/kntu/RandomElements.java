/**
 * this class models elements who became to life of the screen every 15 seconds in spaceships row
 * and by getting them spaceship maybe able to use from some advantages
 */
package ir.ac.kntu;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.awt.*;

public class RandomElements extends Rectangle {
    private boolean isDead = false;

    public RandomElements(int x, int y, Image img) {
        super(x, y, 50, 50);
        this.setFill(new ImagePattern(img));
        DataBase.getDataBase().getRandomElements().add(this);
    }

    public boolean isDead() {
        return isDead;
    }

    public void dead() {
        isDead = true;
    }
}

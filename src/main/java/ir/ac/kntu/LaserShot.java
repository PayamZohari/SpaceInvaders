/**
 * this is a subclass to Sprite and represents every shoots in the game from both sides
 */
package ir.ac.kntu;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class LaserShot extends Sprite {
    /**
     * this is a inheritance and composition from sprite
     * because it has the shooter field which is one of the sprites
     */
    private Sprite shooter;
    private int angle;

    public LaserShot(int x, int y, int w, int h, Color color, Sprite shooter, int angle) {
        super(x, y, w, h, Color.RED);
        this.shooter = shooter;
        this.angle = angle;

    }

    public Sprite getShooter() {
        return shooter;
    }

    public void setShooter(Sprite shooter) {
        this.shooter = shooter;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }


}

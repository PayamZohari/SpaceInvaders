/**
 * this is the main player of the game and we play with this character
 * it should destroys aliens who are it's enemy
 */
package ir.ac.kntu;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class SpaceShip extends Sprite {
    /**
     * it has health field which represents how many shots it has token by enemies
     */
    private int health = 100;

    public SpaceShip() {
        super(300, 740, 50, 50, new Image("C:\\Users\\SONY\\Desktop\\Zohari-SpaceInvadersProject\\p3-space-invaders\\src\\main\\resources\\assets\\spaceship.png"));
    }

    public SpaceShip(int x) {
        super(300, 740, 50, 50, new Image("C:\\Users\\SONY\\Desktop\\Zohari-SpaceInvadersProject\\p3-space-invaders\\src\\main\\resources\\assets\\spaceship.png"));
        this.setTranslateX(x);
    }

    public SpaceShip(SpaceShip spaceShip) {
        super((int) spaceShip.getX(), (int) spaceShip.getY(), (int) spaceShip.getWidth(), (int) spaceShip.getHealth(), new Image("C:\\Users\\SONY\\Desktop\\temp\\p3-space-invaders\\src\\main\\resources\\assets\\spaceship.png"));
        this.setHealth(spaceShip.getHealth());
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health <= 100) {
            this.health = health;
        } else {
            this.health = 100;
        }
    }
}

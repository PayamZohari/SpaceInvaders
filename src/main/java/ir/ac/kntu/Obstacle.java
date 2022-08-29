/**
 * this is a sublcass to Sprites to and doesnt shoot
 * it just is a obstacle and will be remain till it got (5 : health field) shots by any object from both sides
 */

package ir.ac.kntu;

import javafx.scene.image.Image;

public class Obstacle extends Sprite {
    private int health = 5;

    public Obstacle(int x, int y) {
        super(x, y, 40, 40, new Image("C:\\Users\\SONY\\Desktop\\Zohari-SpaceInvadersProject\\p3-space-invaders\\src\\main\\resources\\assets\\obstacle.png"));
        DataBase.getDataBase().getObstacles().add(this);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}

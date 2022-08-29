/**
 * this is the final alien which comes in third level ( and very last one)
 * it is also a sprite so is a subclass to that
 */

package ir.ac.kntu;

import javafx.scene.image.Image;

public class Finalboss extends Sprite {
    /**
     * this giantic alien has health too ( like the space ship)
     */
    private int finalBossHealth = 100;

    public Finalboss() {
        super(300, 300, 100, 100, new Image("C:\\Users\\SONY\\Desktop\\temp\\p3-space-invaders\\src\\main\\resources\\assets\\finalboss.png"));
    }

    public int getFinalBossHealth() {
        return finalBossHealth;
    }

    public void setFinalBossHealth(int finalBossHealth) {
        this.finalBossHealth = finalBossHealth;
    }

    /**
     * this methood is a void method for modeling final bosses movements
     * this alien move quite random in 3 ways(down right left) and wont be able to get out of page
     */
    public void move() {
        double rand = Math.random();
        if (rand < 0.1) {
            this.moveDown(1);
        } else if (rand < 0.55 && rand > 0.1) {
            this.moveRight();
        } else if (rand > 0.55 && rand < 1.0) {
            this.moveLeft();
        }
    }


}

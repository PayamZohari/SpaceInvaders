/**
 * this class is a subclass to sprite
 * models ufo who move very fast upper than aliens , dont shoot but have most score
 */
package ir.ac.kntu;

import javafx.scene.image.Image;

public class UFO extends Sprite {
    public UFO(int x, int y) {
        super(x, y, 40, 40, new Image("C:\\Users\\SONY\\Desktop\\Zohari-SpaceInvadersProject\\p3-space-invaders\\src\\main\\resources\\assets\\ufo.png"));
        DataBase.getDataBase().getUfos().add(this);
    }
}

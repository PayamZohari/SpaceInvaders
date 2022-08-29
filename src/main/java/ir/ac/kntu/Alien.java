/**
 * represents aliens including primary and secondary aliens who
 * will derive from this class
 */
package ir.ac.kntu;

import javafx.scene.image.Image;

/**
 * aliens are also rectangle so this class is a subclass to rectangle class of javafx
 */
public class Alien extends Sprite {
    /**
     * in constructor it will get the position of alien and their image
     */
    public Alien(int x, int y, Image img) {
        super(x, y, 40, 40, img);
        DataBase.getDataBase().getAliens().add(this);
    }

}

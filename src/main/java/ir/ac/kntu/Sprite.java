/**
 * this class models everything including enemies and spaceship
 * it is a subclass to rectangle class of javafx
 */

package ir.ac.kntu;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

public class Sprite extends Rectangle {
    private static int endX = 0;
    private static int endY = 0;

    private boolean isDead;

    public Sprite(int x, int y, int w, int h, Image img) {
        super(x, y, w, h);
        this.setFill(new ImagePattern(img));
        isDead = false;
        DataBase.getDataBase().getSprites().add(this);
    }

    public Sprite(int x, int y, int w, int h, Color color) {
        super(x, y, w, h);
        this.setFill(color);
        isDead = false;
        DataBase.getDataBase().getSprites().add(this);
    }

    public Sprite(Sprite sprite) {
        super(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
    }


    public static int getEndX() {
        return endX;
    }

    public static int getEndY() {
        return endY;
    }

    public static void setEndX(int endX) {
        Sprite.endX = endX;
    }

    public static void setEndY(int endY) {
        Sprite.endY = endY;
    }

    /**
     * let sprite move left for 10 steps
     *
     * @return true if the move has been accomplished
     */
    boolean moveLeft() {
        if (this.getTranslateX() - 10 > -endX / 2) {
            setTranslateX(getTranslateX() - 10);
            return true;
        } else {
            return false;
        }
    }

    boolean moveLeft(double level) {
        if (this.getTranslateX() - 10 > -endX / 2 + 220) {
            setTranslateX(getTranslateX() - level * 2);
            return true;
        } else {
            return false;
        }
    }

    /**
     * let sprite move right for 10 steps
     *
     * @return true if the move has been accomplished
     */
    boolean moveRight() {
        if (getTranslateX() + 10 < endX / 2 - getWidth()) {
            setTranslateX(getTranslateX() + 10);
            return true;
        } else {
            return false;
        }
    }

    boolean moveRight(double level) {
        if (getTranslateX() + 10 < endX / 2 - getWidth() - 250) {
            setTranslateX(getTranslateX() + level * 2);
            return true;
        } else {
            return false;
        }
    }

    /**
     * simply moves the sprite up for 10 stpes
     */
    void moveUp() {
        setTranslateY(getTranslateY() - 10);
    }

    void moveUpRight() {
        setTranslateY(getTranslateY() - 8);
        setTranslateX(getTranslateX() + 4);
    }


    void moveUpLeft() {
        setTranslateY(getTranslateY() - 8);
        setTranslateX(getTranslateX() - 4);
    }

    /**
     * simply moves sprite down for 10 steps
     *
     * @param level
     */
    void moveDown(int level) {
        setTranslateY(getTranslateY() + 5 * level);

    }


    void moveDownRight(int level) {
        setTranslateY(getTranslateY() + 4 * level);
        setTranslateX(getTranslateX() + 2 * level);
    }

    void moveDownLeft(int level) {
        setTranslateY(getTranslateY() + 4 * level);
        setTranslateX(getTranslateX() - 2 * level);
    }

    public boolean isDead() {
        return isDead;
    }

    public void dead() {
        isDead = true;
    }

    /**
     * this is a shoot for secondary aliens to the exact place of spaceship
     *
     * @param x1 alien's x
     * @param y1 alien's y
     * @param x2 spaceship'x
     * @param y2 spaceship's y
     */
    void autoAngleMoveDown(int x1, int y1, int x2, int y2) {
        setTranslateY(getTranslateY() + (y2 - y1) / 100);
        setTranslateX(getTranslateX() + (x2 - x1) / 100);
    }
}

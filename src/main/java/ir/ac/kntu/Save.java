package ir.ac.kntu;

import java.util.ArrayList;

public class Save {
    private Account account;
    private int lastScore;
    private ArrayList<Sprite> sprites;
    private SpaceShip spaceship;
    private int lastClockNum;


    public Save(Account account, int lastScore, ArrayList<Sprite> sprites, SpaceShip spaceShip, int clockNum, int lastX) {
        this.account = account;
        this.lastScore = lastScore;
        this.lastClockNum = clockNum;
        this.sprites = sprites;
        this.spaceship = new SpaceShip(spaceShip);
        spaceship.setX(lastX - 300);


    }

    public Account getAccount() {
        return account;
    }

    public int getLastScore() {
        return lastScore;
    }

    public ArrayList<Sprite> getSprites() {
        return sprites;
    }

    public SpaceShip getSpaceShip() {
        return spaceship;
    }

    public int getLastClockNum() {
        return lastClockNum;
    }


    public void setAccount(Account account) {
        this.account = account;
    }

    public void setLastScore(int lastScore) {
        this.lastScore = lastScore;
    }

    public void setSprites(ArrayList<Sprite> sprites) {
        this.sprites = sprites;
    }

    public void setSpaceShip(SpaceShip spaceShip) {
        this.spaceship = spaceShip;
    }

    public void setLastClockNum(int lastClockNum) {
        this.lastClockNum = lastClockNum;
    }

}

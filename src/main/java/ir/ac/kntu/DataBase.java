/**
 * this class is simply a database for our project
 * every single created object will be ket in arraylist pf this class
 */

package ir.ac.kntu;

import java.util.ArrayList;

public class DataBase {
    /**
     * notice that this class has been created in a SINGLETON way
     */
    private static DataBase dataBase = new DataBase();
    private ArrayList<Sprite> sprites;
    private ArrayList<Alien> aliens;
    private ArrayList<UFO> ufos;
    private ArrayList<LaserShot> laserShots;
    private ArrayList<Obstacle> obstacles;
    private ArrayList<RandomElements> randomElements;
    private ArrayList<SaveLevel> saveLevels;
    private ArrayList<Account> accounts;

    private DataBase() {
        sprites = new ArrayList<>();
        aliens = new ArrayList<>();
        ufos = new ArrayList<>();
        laserShots = new ArrayList<>();
        obstacles = new ArrayList<>();
        randomElements = new ArrayList<>();
        saveLevels = new ArrayList<>();
        accounts = new ArrayList<>();
    }

    public static DataBase getDataBase() {
        return dataBase;
    }

    public ArrayList<Sprite> getSprites() {
        return sprites;
    }

    public ArrayList<Alien> getAliens() {
        return aliens;
    }

    public ArrayList<UFO> getUfos() {
        return ufos;
    }

    public ArrayList<LaserShot> getLaserShots() {
        return laserShots;
    }

    public ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }

    public ArrayList<RandomElements> getRandomElements() {
        return randomElements;
    }

    public ArrayList<SaveLevel> getSaveLevels() {
        return saveLevels;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
}

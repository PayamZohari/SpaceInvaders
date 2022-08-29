package ir.ac.kntu;

import com.sun.javafx.scene.control.InputField;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Scanner;


public class SpaceInvadersGame extends Application {
    private int threeShots = 0;
    private ArrayList<Finalboss> finalbosses = new ArrayList<Finalboss>();
    private boolean win = false;

    private int lastLevel = 1;
    private int lastLevelScore = 0;
    private int lastLevelHealth = 100;

    private Stage stage = new Stage();
    private int lastX = 300;
    private Pane temp = new Pane();

    private Label l = new Label("your name : unknown");

    {
        l.setFont(Font.font(40));
        l.setTextFill(Color.GREEN);
        l.setLayoutX(150);
        l.setLayoutY(100);
    }

    private String name = "no name";
    private boolean newGame = true;
    private Text playerName = new Text("player name : " + name);

    {
        playerName.setFill(Color.GREEN);
        playerName.setX(150);
        playerName.setY(500);
        playerName.setFont(Font.font(30));
    }

    private boolean easy = true;
    private boolean medium = false;
    private boolean hard = false;
    Rectangle healthRectangle = new Rectangle(480, 705, 100, 40);

    {
        healthRectangle.setFill(Color.GREEN);
    }

    private Text heart = new Text("health : ");

    {
        heart.setX(400);
        heart.setY(740);
        heart.setFont(Font.font(20));
        heart.setFill(Color.RED);
    }

    private Text gameLevel = new Text("level :" + 1);

    {
        gameLevel.setX(40);
        gameLevel.setY(740);
        gameLevel.setFont(Font.font(20));
        gameLevel.setFill(Color.YELLOW);

    }

    private boolean shielded = false;
    private int countDownForShield = 0;
    private int countDownForLasergun = 0;
    private Text starter = new Text();

    {
        starter.setX(300);
        starter.setY(400);
        starter.setFont(Font.font(100));
        starter.setFill(Color.GREEN);
    }

    private Text timeTh = new Text("timer of thread :" + 0);

    {
        timeTh.setX(100);
        timeTh.setY(400);
        timeTh.setFont(Font.font(20));
        timeTh.setFill(Color.ORANGE);
    }

    private int clockNum = 0;
    private Text clock = new Text("timer :" + 0);
    private int counter = 1;
    private boolean laserGun = false;
    private boolean ufoLeft = true;
    Pane temp12 = new Pane();
    private Scene scene = new Scene(temp12);

    {
        scene.setFill(new ImagePattern(new Image("C:\\Users\\SONY\\Desktop\\temp\\p3-space-invaders\\src\\main\\resources\\assets\\background.jpg")));
    }

    private boolean start = false;
    private Text level2 = new Text("level:" + 1);

    {
        level2.setX(500);
        level2.setY(50);
    }

    private boolean unique = true;
    private boolean goingLeft = true;
    private boolean goingRight = true;
    private boolean pause = false;
    private int score = 0;
    private Text scoreboard = new Text("score : " + 0);
    private double time = 0;
    private Pane root = new Pane();
    private SpaceShip spaceShip = new SpaceShip();
    private DataBase dataBase = DataBase.getDataBase();

    {
        dataBase.getSprites().add(spaceShip);
    }

    private int level = 1;

    private AnimationTimer animationTimer = new AnimationTimer() {
        @Override
        public void handle(long l) {


            if (!pause) {
                /*
                try {
                    timerThread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                */

                update();
            }
        }
    };
/*
    private void save(){

        for(Save s : DataBase.getDataBase().getSaves()){
            if(s.getAccount().getName().equals(this.name)){
                DataBase.getDataBase().getSaves().remove(s);
            }
        }

        Account tempAccount = new Account(name,score);
        for(Account a : DataBase.getDataBase().getAccounts()){
            if(a.getName().equals(name)){
                tempAccount = a;
                if(score>a.getHighestScore()){
                    a.setHighestScore(score);
                }
            }
        }
        Save save = new Save(tempAccount,tempAccount.getHighestScore(),DataBase.getDataBase().getSprites(),spaceShip,clockNum,(int)spaceShip.getX());

    }

    private void load(Save s){

        for(Sprite sprite : DataBase.getDataBase().getSprites()){
            root.getChildren().remove(sprite);
          //  DataBase.getDataBase().getSprites().remove(sprite);
        }


        this.clockNum = s.getLastClockNum();
        clock.setText("timer : "+clockNum);
        this.score = s.getLastScore();
        scoreboard.setText("score : "+score);
        SpaceShip newSpaceShip = new SpaceShip((int)s.getSpaceShip().getTranslateX());
        newSpaceShip.setHealth(s.getSpaceShip().getHealth());
       spaceShip = newSpaceShip;
       root.getChildren().add(spaceShip);
       healthRectangle.setWidth(spaceShip.getHealth());
    for(Sprite spr : s.getSprites()){
        if(!(spr instanceof SpaceShip)) {
            root.getChildren().add(spr);
        }
    }
    }
*/

    ////////////////////////////save level

    /**
     * this method will save the game
     */
    private void saveLevel() {
        Account account = new Account(name, 0);
        for (SaveLevel s : DataBase.getDataBase().getSaveLevels()) {
            if (name.equals(s.getAccount().getName())) {
                account = s.getAccount();
            }
        }
        SaveLevel saveLevel = new SaveLevel(account, lastLevelScore, lastLevelHealth, lastLevel);
    }

    /**
     * this method will simply load the game
     *
     * @param saveLevel
     */

    private void loadLevel(SaveLevel saveLevel) {
        newGame = false;
        this.lastLevelScore = 0;
        this.lastLevelHealth = 100;
        this.lastLevel = 1;
        this.level = saveLevel.getLevel();
        gameLevel.setText("level : " + level);
        this.name = saveLevel.getAccount().getName();
        this.score = saveLevel.getScore();
        scoreboard.setText("score : " + score);
        this.spaceShip.setHealth(saveLevel.getHealth());
        healthRectangle.setWidth(spaceShip.getHealth());
    }

    /**
     * with this method we create final boss in last level
     */
    private void finalBossComes() {
        Finalboss f = new Finalboss();
        root.getChildren().add(f);
        finalbosses.add(f);
    }

    /**
     * this is a method for random creation of aliens and enemies of spaceship
     * for each level
     *
     * @return arraylist of sprite including spaceships' enemies
     */
    private ArrayList<Sprite> createAliens() {
        ArrayList<Sprite> sprites = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            if (Math.random() > 0.5) {
                UFO ufoTemp = new UFO(550 - 80 * i, 50 + (level - 1) * 50);
                root.getChildren().add(ufoTemp);
                dataBase.getSprites().add(ufoTemp);
                sprites.add(ufoTemp);
            }
        }

        int row1 = (int) (Math.random() * 2 * level - 1);
        int col1 = (int) (Math.random() * 6);

        int row2 = (int) (Math.random() * 2 * level - 1);
        int col2 = (int) (Math.random() * 6);

        int row3 = (int) (Math.random() * 2 * level - 1);
        int col3 = (int) (Math.random() * 6);

        for (int i = 0; i < 2 * level; i++) {
            for (int j = 0; j < 7; j++) {
                if ((i == row1 && j == col1) || (i == row2 && j == col2) || (i == row3 && j == col3)) {
                    Obstacle obs = new Obstacle(550 - 80 * j, 100 + 80 * i + (level - 1) * 50);
                    root.getChildren().add(obs);
                    dataBase.getSprites().add(obs);
                    sprites.add(obs);
                } else if (Math.random() > 0.2) {
                    PrimaryAlien pAlien = new PrimaryAlien(550 - 80 * j, 100 + 80 * i + (level - 1) * 50);
                    root.getChildren().add(pAlien);
                    dataBase.getSprites().add(pAlien);
                    sprites.add(pAlien);
                } else {
                    SecondaryAlien pAlien = new SecondaryAlien(550 - 80 * j, 100 + 80 * i + (level - 1) * 50);
                    root.getChildren().add(pAlien);
                    dataBase.getSprites().add(pAlien);
                    sprites.add(pAlien);
                }

            }
        }

        return sprites;
    }

    /**
     * this a shoot method for just spaceship
     *
     * @param shooter is who has shoot the laserShot which is obviously a sprite
     * @param angle   is gonna tell the program how the laser shot gonna be shooted
     */

    private void shoot(Sprite shooter, int angle) {
        LaserShot ls = new LaserShot((int) (shooter.getTranslateX() + Sprite.getEndX() / 2 + shooter.getWidth() / 2),
                (int) (shooter.getTranslateY() + Sprite.getEndY() - shooter.getHeight() / 2)
                , 10, 10, Color.RED, shooter, angle);
        root.getChildren().add(ls);
    }

    private void shootBoss() {
        Finalboss temp = finalbosses.get(0);
        double random = Math.random();
        if (random > 0.5) {
            threeShots = 3;
            LaserShot ls1 = new LaserShot((int) finalbosses.get(0).getX(), (int) finalbosses.get(0).getY(), 5, 5, Color.BLUE, finalbosses.get(0), 0);
            LaserShot ls2 = new LaserShot((int) finalbosses.get(0).getX() + 100, (int) finalbosses.get(0).getY(), 5, 5, Color.BLUE, finalbosses.get(0), 0);
            LaserShot ls3 = new LaserShot((int) finalbosses.get(0).getX() - 100, (int) finalbosses.get(0).getY(), 5, 5, Color.BLUE, finalbosses.get(0), 0);
            DataBase.getDataBase().getSprites().add(ls1);
            DataBase.getDataBase().getSprites().add(ls2);
            DataBase.getDataBase().getSprites().add(ls3);
        } else {
            LaserShot ls1 = new LaserShot((int) finalbosses.get(0).getX(), (int) finalbosses.get(0).getY(), 5, 5, Color.BLUE, finalbosses.get(0), 0);
            DataBase.getDataBase().getSprites().add(ls1);
        }

    }

    /**
     * this is a method for creating lasershots from aliens side
     *
     * @param x is an alien which is the one who has shooted the laseshot
     */

    private void shootAlien(Alien x) {
        LaserShot ls = new LaserShot((int) (x.getX()),
                (int) (x.getY() + x.getHeight())
                , 10, 10, Color.RED, x, 0);
        root.getChildren().add(ls);

    }


    private void update() {
        time += 0.10;

        if (finalbosses.size() > 0) {
            finalbosses.get(0).move();
        }


        boolean goDown = false;

        if (clockNum > 5) {
            if (ufoLeft) {
                for (UFO u : DataBase.getDataBase().getUfos()) {
                    ufoLeft = u.moveLeft(4);
                }
            } else {
                for (UFO u : DataBase.getDataBase().getUfos()) {
                    ufoLeft = !(u.moveRight(4));
                }
            }

            if (goingLeft) {
                for (int i = 0; i < DataBase.getDataBase().getAliens().size(); i++) {
                    goingLeft = DataBase.getDataBase().getAliens().get(i).moveLeft(0.2);
                    if (!goingLeft) {
                        goDown = true;
                        goingRight = true;
                    }
                }
            } else if (goingRight) {
                for (int i = 0; i < DataBase.getDataBase().getAliens().size(); i++) {
                    goingRight = DataBase.getDataBase().getAliens().get(i).moveRight(0.2);
                }
                if (!goingRight) {
                    goDown = true;
                    goingLeft = true;
                }
            }
            if (goDown) {
                for (int i = 0; i < DataBase.getDataBase().getAliens().size(); i++) {
                    DataBase.getDataBase().getAliens().get(i).moveDown(2 * level);
                    if (DataBase.getDataBase().getAliens().get(i).getY() > 600) {
                        spaceShip.dead();
                    }
                }
            }
        }


        for (Sprite a : DataBase.getDataBase().getSprites()) {
            if (a instanceof Alien) {
                if (a.isDead() && DataBase.getDataBase().getSprites().size() != 1) {
                    DataBase.getDataBase().getAliens().remove(a);
                } else if (a.isDead() && DataBase.getDataBase().getSprites().size() == 1) {
                    DataBase.getDataBase().getAliens().remove(a);
                    root.getChildren().add(a);
                }
            }
        }

        if (time > 10 && clockNum > 8) {
            if (level != 3) {
                for (Alien a : DataBase.getDataBase().getAliens()) {
                    if (!a.isDead()) {
                        if (Math.random() < 0.2) {
                            shootAlien(a);
                            break;
                        }
                    }
                }
            } else {
                double random = Math.random();
                if (random > 0.5) {

                }
            }

        }

        for (Sprite s : DataBase.getDataBase().getSprites()) {
            if (s instanceof LaserShot) {
                if (((LaserShot) s).getShooter() instanceof SpaceShip) {
                    if (((LaserShot) s).getAngle() == 45) {
                        s.moveUpRight();
                    } else if (((LaserShot) s).getAngle() == 135) {
                        s.moveUpLeft();
                    } else {
                        s.moveUp();
                    }

                    if (DataBase.getDataBase().getAliens().size() > 0) {
                        for (Alien a : DataBase.getDataBase().getAliens()) {
                            if ((a.isDead() != true) && s.getBoundsInParent().intersects(a.getBoundsInParent()) && (!s.isDead() || laserGun)) {
                                s.dead();
                                root.getChildren().remove(s);
                                a.dead();
                                a.setFill(new ImagePattern(new Image("C:\\Users\\SONY\\Desktop\\temp\\p3-space-invaders\\src\\main\\resources\\assets\\exploding.jpg")));

                                root.getChildren().remove(a);
                                if (a instanceof PrimaryAlien) {
                                    score++;
                                } else if (a instanceof SecondaryAlien) {
                                    score = score + 2;
                                }
                                scoreboard.setText("score : " + score);
                            }

                        }
                    }


                    if (DataBase.getDataBase().getUfos().size() > 0) {
                        for (UFO u : DataBase.getDataBase().getUfos()) {
                            if (s.isDead() && !laserGun) {
                                break;
                            }
                            if (!u.isDead() && s.getBoundsInParent().intersects(u.getBoundsInParent())) {
                                s.dead();
                                root.getChildren().remove(s);
                                u.dead();
                                root.getChildren().remove(u);
                                score = score + 5;
                                scoreboard.setText("score : " + score);
                            }
                        }
                    }
////////////////////////////////////////////obstacle/////////////////////////////////////////////////////
                    if (DataBase.getDataBase().getObstacles().size() > 0) {
                        for (Obstacle o : DataBase.getDataBase().getObstacles()) {
                            if (s.isDead() && !laserGun) {
                                break;
                            }
                            if (!o.isDead() && s.getBoundsInParent().intersects(o.getBoundsInParent())) {
                                s.dead();
                                root.getChildren().remove(s);
                                o.setHealth(o.getHealth() - 1);
                                if (o.getHealth() <= 0) {
                                    o.dead();
                                    root.getChildren().remove(o);
                                }
                            }
                        }
                    }

                    if (finalbosses.size() > 0) {
                        if (!finalbosses.get(0).isDead() && s.getBoundsInParent().intersects(finalbosses.get(0).getBoundsInParent())) {
                            s.dead();
                            root.getChildren().remove(s);
                            finalbosses.get(0).setFinalBossHealth(finalbosses.get(0).getFinalBossHealth() - 1);
                            if (finalbosses.get(0).getFinalBossHealth() <= 0) {
                                finalbosses.get(0).dead();
                                root.getChildren().remove(finalbosses.get(0));
                            }
                            score = score + 15;
                            scoreboard.setText("score : " + score);
                        }
                    }
                    ////////////////////////shoot by primary alien////////////////////////////////////
                } else if (((LaserShot) s).getShooter() instanceof PrimaryAlien) {
                    s.moveDown(level);
                    if (s.getBoundsInParent().intersects(spaceShip.getBoundsInParent())) {
                        s.dead();
                        root.getChildren().remove(s);
                        if (!shielded) {
                            spaceShip.setHealth(spaceShip.getHealth() - 1);
                            healthRectangle.setWidth(spaceShip.getHealth());
                        }
                        if (spaceShip.getHealth() <= 0) {
                            spaceShip.dead();
                            root.getChildren().remove(spaceShip);
                        }
                    }
                    ///////////////////////obstacle//////////////////////////////////////////////////////////
                    if (DataBase.getDataBase().getObstacles().size() > 0) {
                        for (Obstacle o : DataBase.getDataBase().getObstacles()) {
                            if (s.isDead() && !laserGun) {
                                break;
                            }
                            if (!o.isDead() && s.getBoundsInParent().intersects(o.getBoundsInParent())) {
                                s.dead();
                                root.getChildren().remove(s);
                                o.setHealth(o.getHealth() - 1);
                                if (o.getHealth() <= 0) {
                                    o.dead();
                                    root.getChildren().remove(o);
                                }
                            }
                        }
                    }
                    /////////////////////shoot by sec alien///////////////////////
                } else if (((LaserShot) s).getShooter() instanceof SecondaryAlien) {
                    s.autoAngleMoveDown((int) ((LaserShot) s).getShooter().getX(),
                            (int) (((LaserShot) s).getShooter().getY()),
                            (int) (spaceShip.getX() - 300), (int) (spaceShip.getY()));
                    if (s.getBoundsInParent().intersects(spaceShip.getBoundsInParent())) {
                        s.dead();
                        root.getChildren().remove(s);
                        if (!shielded) {
                            spaceShip.setHealth(spaceShip.getHealth() - 2);
                            healthRectangle.setWidth(spaceShip.getHealth());
                        }
                        if (spaceShip.getHealth() <= 0) {
                            spaceShip.dead();
                            root.getChildren().remove(spaceShip);
                        }
                    }
                    ///////////////obstacle///////////////////////////////////////
                    if (DataBase.getDataBase().getObstacles().size() > 0) {
                        for (Obstacle o : DataBase.getDataBase().getObstacles()) {
                            if (s.isDead() && !laserGun) {
                                break;
                            }
                            if (!o.isDead() && s.getBoundsInParent().intersects(o.getBoundsInParent())) {
                                s.dead();
                                root.getChildren().remove(s);
                                o.setHealth(o.getHealth() - 1);
                                if (o.getHealth() <= 0) {
                                    o.dead();
                                    root.getChildren().remove(o);
                                }
                            }
                        }
                    }
                } else if (((LaserShot) s).getShooter() instanceof Finalboss) {
                    if (threeShots > 0) {
                        s.moveDown(2);
                        threeShots--;
                    } else {
                        Sprite temp = ((LaserShot) s).getShooter();
                        s.autoAngleMoveDown((int) temp.getX(), (int) temp.getY(), (int) spaceShip.getX(), (int) spaceShip.getY());
                    }

                    if (s.getBoundsInParent().intersects(spaceShip.getBoundsInParent())) {
                        s.dead();
                        root.getChildren().remove(s);
                        if (!shielded) {
                            spaceShip.setHealth(spaceShip.getHealth() - 2);
                            healthRectangle.setWidth(spaceShip.getHealth());
                        }
                        if (spaceShip.getHealth() <= 0) {
                            spaceShip.dead();
                            root.getChildren().remove(spaceShip);
                        }
                    }

                }
            }

        }


        if (DataBase.getDataBase().getAliens().size() == 0) {
            lastLevel = level;
            lastLevelScore = score;
            lastLevelHealth = spaceShip.getHealth();
            if (level < 3) {
                level++;
            } else if (level == 3 && finalbosses.get(0).isDead()) {
                level++;
            }
            if (level == 3) {
                finalBossComes();
            } else if (level < 3) {
                createAliens();
            } else {
                spaceShip.dead();
                win = true;
            }
            gameLevel.setText("level : " + level);
        }

        for (Alien a : DataBase.getDataBase().getAliens()) {
            if (!a.isDead() && a.getY() > 600) {
                spaceShip.dead();
            }
        }

        if (finalbosses.size() > 0 && level == 3) {
            if (finalbosses.get(0).getBoundsInParent().intersects(spaceShip.getBoundsInParent()) && !(finalbosses.get(0).isDead())) {
                spaceShip.dead();
            }
        }
/*
    for(Sprite s : DataBase.getDataBase().getSprites()){
        if(s.isDead()){
            DataBase.getDataBase().getSprites().remove(s);
        }
    }
*/
        if (time > 10) {
            clockNum = (int) (time * counter / 10);
            if (clockNum > 5) {
                clock.setText("timer : " + (clockNum - 5));
            }
            starter.setText(Integer.toString(6 - clockNum));
            if (clockNum > 5) {
                root.getChildren().remove(starter);
            }
            clock.setFill(Color.ORANGE);
            clock.setFont(Font.font(20));
            clock.setFill(Color.YELLOW);
            clock.setX(480);
            clock.setY(40);
            time = 0;
            counter++;
        }

        for (Alien a : DataBase.getDataBase().getAliens()) {
            if (a.getBoundsInParent().intersects(spaceShip.getBoundsInParent())) {
                spaceShip.dead();
                root.getChildren().remove(spaceShip);
            }
        }


        if ((clockNum % 15 == 0) && clockNum > 0) {
            if (DataBase.getDataBase().getRandomElements().size() > 0) {
                for (RandomElements r : DataBase.getDataBase().getRandomElements()) {
                    r.dead();
                    root.getChildren().remove(r);
                }
            }
            double choose = Math.random();
            int xLoc = (int) (Math.random() * 400);
            if (choose < 0.33) {
                Heart h = new Heart(xLoc, 740);
                root.getChildren().add(h);
            } else if (choose >= 0.33 && choose < 0.6) {
                Shield s = new Shield(xLoc, 740);
                root.getChildren().add(s);
            } else {
                Lasergun l = new Lasergun(xLoc, 740);
                root.getChildren().add(l);
            }
        }

        for (RandomElements r : DataBase.getDataBase().getRandomElements()) {
            if (!r.isDead() && r.getBoundsInParent().intersects(spaceShip.getBoundsInParent())) {
                r.dead();
                root.getChildren().remove(r);
                if (r instanceof Heart) {
                    spaceShip.setHealth(spaceShip.getHealth() + 1);
                    healthRectangle.setWidth(spaceShip.getHealth());
                } else if (r instanceof Lasergun) {
                    countDownForLasergun = clockNum;
                    laserGun = true;
                } else if (r instanceof Shield) {
                    countDownForShield = clockNum;
                    shielded = true;
                }
            }
        }
        if (laserGun && clockNum > countDownForLasergun + 10) {
            laserGun = false;
        }

        if (shielded && clockNum > countDownForShield + 7) {
            shielded = false;
        }


        if (clockNum > 120) {
            spaceShip.dead();
        }

        if (spaceShip.isDead()) {
            if (!win) {
                Text gameOver1 = new Text("GAME OVER");
                gameOver1.setX(100);
                gameOver1.setY(400);
                gameOver1.setFont(Font.font(60));
                gameOver1.setFill(Color.RED);
                Text gameOver2 = new Text("your score : " + score);
                gameOver2.setX(100);
                gameOver2.setY(600);
                gameOver2.setFont(Font.font(60));
                gameOver2.setFill(Color.RED);
                root.getChildren().add(gameOver1);
                root.getChildren().add(gameOver2);
                pause = true;
            } else {
                Text gameOver1 = new Text("CONGRATS! YOU WON");
                gameOver1.setX(100);
                gameOver1.setY(400);
                gameOver1.setFont(Font.font(80));
                gameOver1.setFill(Color.GREEN);
                Text gameOver2 = new Text("your score : " + score);
                gameOver2.setX(100);
                gameOver2.setY(600);
                gameOver2.setFont(Font.font(80));
                gameOver2.setFill(Color.GREEN);
                root.getChildren().add(gameOver1);
                root.getChildren().add(gameOver2);
                pause = true;

            }
        }

    }


    @Override
    public void start(Stage stage) {


        Account account1 = new Account("Payam", 20);
        Account account2 = new Account("Ali", 30);
        Account account3 = new Account("Reza", 50);
        Account account4 = new Account("Mohsen", 0);
        Account account5 = new Account("Mahdi", 45);

     /*   PrimaryAlien temporary = new PrimaryAlien(200,200);
        ArrayList<Sprite> temporaryArr = new ArrayList<>();
        temporaryArr.add(temporary);

        Save save1 = new Save(account1,10,new ArrayList<>(),spaceShip,15,400);
        Save save2 = new Save(account3,15,temporaryArr,new SpaceShip(100),8,20);

*/

        SaveLevel saveLevel1 = new SaveLevel(account1, 20, 80, 1);
        SaveLevel saveLevel2 = new SaveLevel(account3, 8, 30, 2);


        Button buttonStart = new Button();
        buttonStart.setText("start");
        buttonStart.setLayoutX(280);
        buttonStart.setLayoutY(480);
        buttonStart.setMaxWidth(200);
        buttonStart.setMaxHeight(200);
        temp.getChildren().add(buttonStart);

        Button buttonEasy = new Button();
        Button buttonMedium = new Button();
        Button buttonHard = new Button();


        BackgroundImage bc = new BackgroundImage(new Image("C:\\Users\\SONY\\Desktop\\temp\\p3-space-invaders\\src\\main\\resources\\assets\\starter4.jpg"),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        temp.setBackground(new Background(bc));

        scene = new Scene(temp, 600, 800, Color.RED);
        scene.setFill(new ImagePattern(new Image("C:\\Users\\SONY\\Desktop\\temp\\p3-space-invaders\\src\\main\\resources\\assets\\background.jpg")));

        EventHandler<ActionEvent> eventStart = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                //  scene.setFill(Color.YELLOW);

                startGame(stage, scene);
            }
        };

        EventHandler<ActionEvent> eventEasy = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                level = 1;
                gameLevel.setText("level : " + 1);
                easy = true;
                medium = false;
                hard = false;
            }
        };

        EventHandler<ActionEvent> eventMedium = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                level = 2;
                gameLevel.setText("level : " + 2);
                easy = false;
                medium = true;
                hard = false;
            }
        };

        EventHandler<ActionEvent> eventHard = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                level = 3;
                gameLevel.setText("level : " + 3);
                easy = false;
                medium = false;
                hard = true;
            }
        };

        Button newGameAnyWay = new Button();
        newGameAnyWay.setLayoutY(450);
        newGameAnyWay.setLayoutX(200);
        newGameAnyWay.setText("dont load last save");


        EventHandler<ActionEvent> newGameEvent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                newGame = true;
            }
        };

        newGameAnyWay.setOnAction(newGameEvent);

        TextField getName = new TextField();
        getName.setLayoutX(220);
        getName.setLayoutY(200);
        temp.getChildren().add(getName);

        EventHandler<ActionEvent> nameForm = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                l.setText("your name : " + getName.getText());
                name = getName.getText();
                playerName.setText("player name : " + name);
            }
        };


        //temp.getChildren().add(newGameAnyWay);

        getName.setOnAction(nameForm);
        temp.getChildren().add(l);

        Text chooser = new Text("choose the level by clicking then press start (defalut is easy)");
        chooser.setX(50);
        chooser.setY(600);
        chooser.setFont(Font.font(20));
        chooser.setFill(Color.RED);
        temp.getChildren().add(chooser);


        buttonStart.setOnAction(eventStart);

        buttonEasy.setOnAction(eventEasy);
        buttonEasy.setText("easy");
        buttonEasy.setLayoutX(100);
        buttonEasy.setLayoutY(650);
        buttonEasy.setMaxWidth(200);
        buttonEasy.setMaxHeight(200);
        temp.getChildren().add(buttonEasy);

        buttonMedium.setOnAction(eventMedium);
        buttonMedium.setText("medium");
        buttonMedium.setLayoutX(300);
        buttonMedium.setLayoutY(650);
        buttonMedium.setMaxWidth(200);
        buttonMedium.setMaxHeight(200);
        temp.getChildren().add(buttonMedium);

        buttonHard.setOnAction(eventHard);
        buttonHard.setText("hard");
        buttonHard.setLayoutX(500);
        buttonHard.setLayoutY(650);
        buttonHard.setMaxWidth(200);
        buttonHard.setMaxHeight(200);
        temp.getChildren().add(buttonHard);


        stage.setScene(scene);
        stage.setTitle("SPACE INVADERS GAME");
        stage.show();

    }

    public void startGame(Stage stage, Scene scene) {
        // timerThread.start();
        //root.getChildren().add(timeTh);
        root.getChildren().add(playerName);
        root.getChildren().add(healthRectangle);
        root.getChildren().add(heart);
        root.getChildren().add(gameLevel);
        root.getChildren().add(starter);
        root.getChildren().add(clock);
        int endX = 600;
        int endY = 800;
        Sprite.setEndX(endX);
        Sprite.setEndY(endY);
        //////////////////////////////////////////
            /*for(Save s : DataBase.getDataBase().getSaves()){
                if(s.getAccount().getName().equals(name)){
                    newGame = false;
                    for(Sprite sprite : DataBase.getDataBase().getSprites()){
                        root.getChildren().remove(sprite);
                    }
                    load(s);
                }
            }*/
            /*
        if(DataBase.getDataBase().getSaveLevels().size()>0) {
            for (SaveLevel s : DataBase.getDataBase().getSaveLevels()) {
                if (s.getAccount().getName().equals(name) && !newGame) {
                    loadLevel(s);
                }
            }
        }
        */

        spaceShip.setX(300);
        root.getChildren().add(spaceShip);
        createAliens();
        //////////////////////////////////////////
        scene = new Scene(root, endX, endY, Color.RED);
        scene.setFill(new ImagePattern(new Image("C:\\Users\\SONY\\Desktop\\temp\\p3-space-invaders\\src\\main\\resources\\assets\\background.jpg")));


        BackgroundImage bc = new BackgroundImage(new Image("C:\\Users\\SONY\\Desktop\\temp\\p3-space-invaders\\src\\main\\resources\\assets\\background.jpg"),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        root.setBackground(new Background(bc));
        Text text = new Text("SPACE INAVADERS");
        text.setFill(Color.ORANGE);
        text.setFont(Font.font(25));
        text.setX(200);
        text.setY(40);


        scoreboard.setFill(Color.YELLOW);
        scoreboard.setFont(Font.font(20));
        scoreboard.setX(40);
        scoreboard.setY(40);
        root.getChildren().add(text);
        root.getChildren().add(scoreboard);

        animationTimer.start();


        scene.setOnKeyPressed(x -> {
            switch (x.getCode()) {
                case A:
                    if (!pause && clockNum > 5) {
                        spaceShip.moveLeft();
                    }
                    break;
                case D:
                    if (!pause && clockNum > 5) {
                        spaceShip.moveRight();
                    }
                    break;
                case W:
                    if (!pause && clockNum > 5) {
                        shoot(spaceShip, 0);
                    }
                    break;
                case E:
                    if (!pause && clockNum > 5) {
                        shoot(spaceShip, 45);
                    }
                    break;
                case Q:
                    if (!pause && clockNum > 5) {
                        shoot(spaceShip, 135);
                    }
                    break;
                case SPACE:
                    pause = true;
                    break;
                case ENTER:
                    pause = false;
                    break;
                case S:
                    pause = true;
                    saveLevel();
                    break;

            }

        });
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    public static void main(String[] args) {


        launch(args);
    }
}

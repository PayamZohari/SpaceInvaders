/**
 * represents the account for each player including his/her total highscore
 * and his/her name
 */

package ir.ac.kntu;

/**
 * this class is gonna be used as composition in save class
 */

public class Account {
    private String name;
    private int highestScore = 0;

    public Account(String name, int highestScore) {
        this.name = name;
        this.highestScore = highestScore;

        DataBase.getDataBase().getAccounts().add(this);
    }

    public String getName() {
        return name;
    }

    public int getHighestScore() {
        return highestScore;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHighestScore(int highestScore) {
        this.highestScore = highestScore;
    }
}

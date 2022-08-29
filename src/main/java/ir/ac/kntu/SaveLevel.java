package ir.ac.kntu;

public class SaveLevel {
    private Account account;
    private int score;
    private int health;
    private int level;

    public SaveLevel(Account account, int score, int health, int level) {
        this.score = score;
        this.health = health;
        this.level = level;

        DataBase.getDataBase().getSaveLevels().add(this);
    }

    public Account getAccount() {
        return account;
    }

    public int getScore() {
        return score;
    }

    public int getHealth() {
        return health;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}

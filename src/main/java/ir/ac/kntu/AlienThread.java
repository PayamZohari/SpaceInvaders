package ir.ac.kntu;

public class AlienThread extends Thread {
    private LaserShot laserShot;

    public AlienThread(LaserShot laserShot) {
        this.laserShot = laserShot;
    }

    public void run() {
        if (laserShot.getShooter() instanceof PrimaryAlien) {
            while (laserShot.isDead()) {
                laserShot.moveDown(1);
            }
        }
    }


}

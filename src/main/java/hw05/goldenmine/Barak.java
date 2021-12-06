package hw05.goldenmine;

import java.util.Date;

public class Barak extends Thread {
    private GoldMine goldMine;
    private Logger logger;
    public Barak(GoldMine goldMine, Logger logger) {
        this.goldMine = goldMine;
        this.logger = logger;
    }

    @Override
    public void run() {
        for (int i = 4; true; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Worker("Worker#" + i, goldMine, logger);
            System.out.println("Worker#" + i + " created " + new Date());
        }
    }
}

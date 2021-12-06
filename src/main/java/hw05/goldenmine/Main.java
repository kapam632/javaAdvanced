package hw05.goldenmine;

public class Main {
    public static void main(String[] args) {
        GoldMine goldMine = new GoldMine();
        Logger logger = new Logger();
        new Worker("Worker#1", goldMine, logger);
        new Worker("Worker#2", goldMine, logger);
        new Worker("Worker#3", goldMine, logger);
        Barak barak = new Barak(goldMine, logger);
        barak.setDaemon(true);
        barak.start();
        logger.infoWorkers();
    }
}

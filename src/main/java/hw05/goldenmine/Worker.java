package hw05.goldenmine;

public class Worker extends Thread {
    private int gold;
    private String name;
    private GoldMine mine;

    public Worker(String name, GoldMine mine, Logger logger) {
        this.name = name;
        this.mine = mine;
        logger.add(this);
        start();
    }

    @Override
    public void run() {
        while (mine.getGold() > 0) {
            gold += mine.mineGold();
            System.out.printf("Worker %s take %s \n", name, gold);
        }
    }

    @Override
    public String toString() {
        return "Worker{" +
                "gold=" + gold +
                ", name='" + name + '\'' +
                '}';
    }
}

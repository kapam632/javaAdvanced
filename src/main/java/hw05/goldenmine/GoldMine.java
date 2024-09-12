package hw05.goldenmine;

public class GoldMine {
    private int gold = 23;

    public synchronized int getGold() {
        return gold;
    }

    public synchronized int mineGold() {
        int slice = takeThreeGoldIfNotEmpty();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return slice;
    }

    private int takeThreeGoldIfNotEmpty() {
        int slice = 0;
        for (int i = 0; i < 3; i++) {
            if (gold > 0) {
                gold--;
                slice++;
            }
        }
        return slice;
    }
}

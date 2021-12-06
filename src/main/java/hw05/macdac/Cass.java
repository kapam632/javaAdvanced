package hw05.macdac;

public class Cass {
    private boolean close;

    public void service() {
        try {
            if (!close) {
                int wp = ((int) (Math.random() * 6) + 3) * 1000;
                System.out.println("service time " + wp);
                Thread.sleep(wp);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isClose() {
        return close;
    }

    public void setClose(boolean close) {
        this.close = close;
    }

}

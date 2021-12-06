package hw06.waitnotify;

import java.util.concurrent.TimeUnit;

public class Loader implements Runnable {
    private Cart cart;
    private Object lock;
    private int moneyHeap = 50;

    public Loader(Cart cart, Object lock) {
        this.cart = cart;
        this.lock = lock;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (moneyHeap > 0) {
            System.out.println("-Loader: load start");
            try {
                for (int i = 0; i < 3; i++) cartLoad();
                cart.setLoaded(true);
                if (moneyHeap == 0) {
                    cart.setEmptyHeap(true);
                }
                synchronized (lock) {
                    lock.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("-Loader: load complete");
            try {
                if (moneyHeap > 0 && cart.isLoaded())
                    synchronized (lock) {
                        lock.wait();
                    }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void cartLoad() throws InterruptedException {
        if (moneyHeap >= 2) {
            moneyHeap -= 2;
            cart.setCargo(cart.getCargo() + 2);
            TimeUnit.SECONDS.sleep(1);
        }
    }
}

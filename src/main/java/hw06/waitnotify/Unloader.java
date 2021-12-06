package hw06.waitnotify;

import java.util.concurrent.TimeUnit;

public class Unloader implements Runnable {
    private Cart cart;
    private Object lock;
    private int money = 0;

    public Unloader(Cart cart, Object lock) {
        this.cart = cart;
//        this.exchanger = exchanger;
        this.lock = lock;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (money != 50){
            synchronized (lock){
                if (!cart.isLoaded()){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("-Unloader: started work");
            try {
                money += cart.getCargo();
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cart.setCargo(0);
            System.out.println("-Unloader: finished work");
            synchronized (lock){
                cart.setLoaded(false);
                lock.notify();
            }
        }
    }
}

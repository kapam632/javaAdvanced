package hw06.waitnotify;

import java.util.concurrent.TimeUnit;

public class Transporter implements Runnable {
    private Cart cart;
    private Object loaderLock;
    private Object unloaderLock;
    private boolean moveForward = true;

    public Transporter(Cart cart, Object loaderLock, Object unloaderLock) {
        this.cart = cart;
        this.loaderLock = loaderLock;
        this.unloaderLock = unloaderLock;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (!cart.isEmptyHeap()) {
            synchronized (loaderLock){
                if (moveForward && !cart.isLoaded()) {
                    try {
                        loaderLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("-Transporter: started work");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("-Transporter: finished work");
            if (moveForward){
                synchronized (unloaderLock){
                    unloaderLock.notify();
                    try {
                        unloaderLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    moveForward = false;
                }
            } else
                synchronized (loaderLock){
                    loaderLock.notify();
                    moveForward = true;
                }
        }
    }
}

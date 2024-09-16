package hw06.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class Loader implements Runnable {
    private Cart cart;
    private Exchanger<Cart> exchanger;
    private int moneyHeap = 20;

    public Loader(Cart cart, Exchanger<Cart> exchanger) {
        this.cart = cart;
        this.exchanger = exchanger;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (moneyHeap > 0) {
            System.out.println("-Loader: load start");
            try {
                for (int i = 0; i < 3; i++) cartLoad();
//                TimeUnit.SECONDS.sleep(3);
                System.out.println(moneyHeap);
                if (moneyHeap == 0){
                    cart.setEmptyHeap(true);
                }
                exchanger.exchange(cart);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("-Loader: load complete");
            try {
                if (moneyHeap > 0)
                exchanger.exchange(null);
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

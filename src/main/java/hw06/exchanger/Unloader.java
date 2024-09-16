package hw06.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class Unloader implements Runnable {
    private Cart cart;
    private Exchanger<Cart> exchanger;
    private int money = 0;

    public Unloader(Cart cart, Exchanger<Cart> exchanger) {
        this.cart = cart;
        this.exchanger = exchanger;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (money != 20){
            try {
                exchanger.exchange(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Unloader started work");
            try {
                money += cart.getCargo();
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cart.setCargo(0);
            System.out.println("Unloader finished work");
            try {
                exchanger.exchange(cart);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

package hw06.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class Transporter implements Runnable {
    private Cart cart;
    private Exchanger<Cart> exchangerL;
    private Exchanger<Cart> exchangerU;
    private boolean moveForward = true;

    public Transporter(Cart cart, Exchanger<Cart> exchangerL, Exchanger<Cart> exchangerU) {
        this.cart = cart;
        this.exchangerL = exchangerL;
        this.exchangerU = exchangerU;
        new Thread(this).start();
    }

    @Override
    public void run() {
//        while (true) {
        while (!cart.isEmptyHeap()) {
            if (moveForward) {
                try {
                    exchangerL.exchange(null);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Transporter started work");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Transporter finished work");
            if (moveForward){
                try {
                    exchangerU.exchange(cart);
                    exchangerU.exchange(null);
                    moveForward = false;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else
            try {
                exchangerL.exchange(cart);
                moveForward = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

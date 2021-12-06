package hw06.waitnotify;

import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();
        Exchanger<Cart> lex = new Exchanger<>();

        Exchanger<Cart> uex = new Exchanger<>();
        new Unloader(cart, uex);
        new Transporter(cart, lex, uex);
        new Loader(cart, lex);
    }
}

package hw06.exchanger;

import java.util.concurrent.atomic.AtomicInteger;

public class Cart {
    private int cargo;
    private boolean emptyHeap;

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public boolean isEmptyHeap() {
        return emptyHeap;
    }

    public void setEmptyHeap(boolean emptyHeap) {
        this.emptyHeap = emptyHeap;
    }
}

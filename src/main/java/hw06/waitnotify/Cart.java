package hw06.waitnotify;

public class Cart {
    private int cargo;
    private boolean emptyHeap;
    private boolean loaded;

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

    public boolean isLoaded() {
        return loaded;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }
}

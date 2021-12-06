package hw05.macdac;

public class Main {
    public static void main(String[] args) {
        Cass cass = new Cass();
        for (int i = 0; i < 5; i++)
        new Client(cass, "Client#" + i);
    }
}

package hw05.macdac;

public class Client extends Thread {
    private final String name;
    private final Cass cass;

    public Client(Cass cass, String name) {
        this.cass = cass;
        this.name = name;
        start();
    }

    @Override
    public void run() {
        synchronized (cass) {
            if (!cass.isClose()) {
                System.out.println("Client " + name + " start service");
                cass.service();
                System.out.println("Client " + name + " finish service");
                cass.setClose(Math.random() < 0.3);
                System.out.println("cass is closed " + cass.isClose());
            }
        }
    }
}

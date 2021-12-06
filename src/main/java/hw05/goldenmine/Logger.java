package hw05.goldenmine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Logger{
    private List<Worker> workers = new ArrayList<>();

    public void add(Worker worker) {
        workers.add(worker);
    }

    public void infoWorkers(){
        while (workers.size() != 0) {
            workers.forEach(System.out::println);
            workers = workers.stream().filter(Thread::isAlive).collect(Collectors.toList());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

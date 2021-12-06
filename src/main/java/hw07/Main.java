package hw07;

import hw07.cat.AglyCat;
import hw07.cat.BlackCat;
import hw07.cat.Cat;
import hw07.cat.FatCat;
import hw07.cat.ThinCat;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Class> classList = new ArrayList<>();
        classList.add(Cat.class);
        classList.add(BlackCat.class);
        classList.add(AglyCat.class);
        classList.add(FatCat.class);
        classList.add(ThinCat.class);
        StuffingFactory.stuffing(classList);
    }
}

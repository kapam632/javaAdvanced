package hw07;

import hw07.annotation.Blohable;
import hw07.annotation.CatYears;
import hw07.annotation.Color;

import java.lang.annotation.Annotation;
import java.util.List;

public class StuffingFactory {

    private StuffingFactory() {
    }

    public static void stuffing(List<Class> classList){
        for(Class clazz : classList){
            CatParams catParams = new CatParams();
            boolean blohable = clazz.isAnnotationPresent(Blohable.class);
            int old = 0;
            String color = null;
            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation annotation : annotations){
                if (annotation instanceof CatYears){
                    CatYears catYears = (CatYears) annotation;
                    old = catYears.old();
                }
                if (annotation instanceof Color){
                    Color catColor = (Color) annotation;
                    color = catColor.color();
                }
                catParams.blohable = blohable;
                catParams.color = color;
                catParams.old = old;
                catParams.className = clazz.getSimpleName();

            }
            print(catParams);
        }
    }

    private static void print(CatParams catParams){
        if (catParams.blohable || catParams.old > 3 || ("black".equalsIgnoreCase(catParams.color) && (int)(Math.random() * 100) < 50)){
            System.out.printf("%s Didn't get into the minced meat\n", catParams.className);
        } else {
            System.out.printf("%s Got into the minced meat\n", catParams.className);
        }
    }

    private static class CatParams {
        private String className;
        private boolean blohable;
        private int old;
        private String color;
    }
}

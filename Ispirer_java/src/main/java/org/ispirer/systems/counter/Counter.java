package org.ispirer.systems.counter;

public class Counter {
    private static int countObjects = 0;

    public Counter() {
        countObjects++;
    }

    public static void count() {
        System.out.println(String.format("Count of objects of %s = %s", Counter.class, countObjects ));
    }
}

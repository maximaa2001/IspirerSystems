package org.ispirer.systems.list;

public class Main {
    public static void main(String[] args) {
        ListUsr<Integer> listUsr = new ListUsr<>(10, new ChangedImpl());
        listUsr.add(20);
        System.out.println(listUsr);
        System.out.println();

        listUsr.add(30);
        System.out.println(listUsr);
        System.out.println();

        System.out.println("Element by index 2 - " + listUsr.get(2));
        System.out.println();

        listUsr.remove(1);
        System.out.println(listUsr);
    }
}

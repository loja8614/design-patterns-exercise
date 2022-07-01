package oop.inheritance.operation.devices.print;

import oop.inheritance.operation.Printer;
import oop.library.vx520.VerifoneVx520Printer;

public class Verifone520Printer implements Printer {
    private VerifoneVx520Printer verifoneVx520Printer = new VerifoneVx520Printer();

    private Verifone520Printer() {

    }
    private static Verifone520Printer uniqueInstance;

    public static Verifone520Printer getInstance() {
        if (uniqueInstance == null) {
            synchronized (Verifone520Printer.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Verifone520Printer();
                }
            }
        }
        return uniqueInstance;
    }


    @Override
    public void print(int x, String message) {
        verifoneVx520Printer.print(x, message);
    }

    @Override
    public void lineFeed() {
        verifoneVx520Printer.lineFeed();

    }
}

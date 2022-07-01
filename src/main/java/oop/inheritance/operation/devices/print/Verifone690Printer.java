package oop.inheritance.operation.devices.print;

import oop.inheritance.operation.Printer;
import oop.library.vx690.VerifoneVx690Printer;

public class Verifone690Printer implements Printer {
    private VerifoneVx690Printer verifoneVx690Printer = new VerifoneVx690Printer();

    private Verifone690Printer() {

    }

    private static Verifone690Printer uniqueInstance;

    public static Verifone690Printer getInstance() {
        if (uniqueInstance == null) {
            synchronized (Verifone690Printer.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Verifone690Printer();
                }
            }
        }
        return uniqueInstance;
    }

    @Override
    public void print(int x, String message) {
        verifoneVx690Printer.print(x, message);
    }

    @Override
    public void lineFeed() {
        verifoneVx690Printer.lineFeed();
    }
}

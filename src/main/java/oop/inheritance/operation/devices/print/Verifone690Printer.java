package oop.inheritance.operation.devices.print;

import oop.inheritance.operation.Printer;
import oop.library.vx690.VerifoneVx690Printer;

public class Verifone690Printer implements Printer {
    private VerifoneVx690Printer verifoneVx690Printer = new VerifoneVx690Printer();

    public Verifone690Printer() {

    }

    private static final class UniqueInstanceHolder {
        private static final Verifone690Printer uniqueInstance = new Verifone690Printer();
    }

    public static Verifone690Printer getInstance() {
        return UniqueInstanceHolder.uniqueInstance;
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

package oop.inheritance.operation.devices.print;

import oop.inheritance.operation.Printer;
import oop.library.vx520.VerifoneVx520Printer;

public class Verifone520Printer implements Printer {
    private VerifoneVx520Printer verifoneVx520Printer = new VerifoneVx520Printer();

    public Verifone520Printer() {

    }

    private static final class UniqueInstanceHolder {
        private static final Verifone520Printer uniqueInstance = new Verifone520Printer();
    }

    public static Verifone520Printer getInstance() {
        return UniqueInstanceHolder.uniqueInstance;
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

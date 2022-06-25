package oop.inheritance.operation.devices.print;

import oop.inheritance.operation.Printer;
import oop.library.v240m.VerifoneV240mPrinter;


public class Verifone240mPrinter implements Printer {
    private VerifoneV240mPrinter verifonePrinter = new VerifoneV240mPrinter();

    public Verifone240mPrinter() {

    }

    private static final class UniqueInstanceHolder {
        private static final Verifone240mPrinter uniqueInstance = new Verifone240mPrinter();
    }

    public static Verifone240mPrinter getInstance() {
        return UniqueInstanceHolder.uniqueInstance;
    }

    @Override
    public void print(int x, String message) {
        verifonePrinter.print(x, message);
    }

    @Override
    public void lineFeed() {
        verifonePrinter.lineFeed();
    }
}

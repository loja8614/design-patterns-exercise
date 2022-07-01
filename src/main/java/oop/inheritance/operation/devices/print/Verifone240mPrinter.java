package oop.inheritance.operation.devices.print;

import oop.inheritance.operation.Printer;
import oop.library.v240m.VerifoneV240mPrinter;


public class Verifone240mPrinter implements Printer {
    private VerifoneV240mPrinter verifonePrinter = new VerifoneV240mPrinter();

    private Verifone240mPrinter() {

    }
    private static Verifone240mPrinter uniqueInstance ;

    public static Verifone240mPrinter getInstance() {
        if (uniqueInstance == null) {
            synchronized (Verifone240mPrinter.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Verifone240mPrinter();
                }
            }
        }
        return uniqueInstance;
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

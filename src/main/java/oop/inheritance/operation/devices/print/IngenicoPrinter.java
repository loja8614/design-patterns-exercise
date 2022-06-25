package oop.inheritance.operation.devices.print;

import oop.inheritance.operation.Printer;

public class IngenicoPrinter implements Printer {
    private oop.library.ingenico.services.IngenicoPrinter ingenicoPrinter = new oop.library.ingenico.services.IngenicoPrinter();

    public IngenicoPrinter() {

    }

    private static final class UniqueInstanceHolder {
        private static final IngenicoPrinter uniqueInstance = new IngenicoPrinter();
    }

    public static IngenicoPrinter getInstance() {
        return UniqueInstanceHolder.uniqueInstance;
    }

    @Override
    public void print(int x, String message) {
        ingenicoPrinter.print(x, message);
    }

    @Override
    public void lineFeed() {
        ingenicoPrinter.lineFeed();

    }
}

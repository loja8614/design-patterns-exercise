package oop.inheritance.operation.devices.print;

import oop.inheritance.operation.Printer;

public class IngenicoPrinter implements Printer {
    private oop.library.ingenico.services.IngenicoPrinter ingenicoPrinter = new oop.library.ingenico.services.IngenicoPrinter();

    private IngenicoPrinter() {

    }

    private static IngenicoPrinter uniqueInstance;

    public static IngenicoPrinter getInstance() {
        if (uniqueInstance == null) {
            synchronized (IngenicoPrinter.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new IngenicoPrinter();
                }
            }
        }
        return uniqueInstance;
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

package oop.inheritance.operation.devices.displays;

import oop.inheritance.operation.Display;
import oop.library.vx520.VerifoneVx520Display;
import oop.library.vx690.VerifoneVx690Display;

public class Verifone520Display implements Display {

    private VerifoneVx520Display verifoneV520Display = new VerifoneVx520Display();

    private Verifone520Display() {

    }

    private static Verifone520Display uniqueInstance;

    public static Verifone520Display getInstance() {

        if (uniqueInstance == null) {
            synchronized (VerifoneVx690Display.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Verifone520Display();
                }
            }
        }
        return uniqueInstance;
    }

    @Override
    public void showMessage(int x, int y, String message) {
        verifoneV520Display.showMessage(message, x, y);
    }

    @Override
    public void clear() {
        verifoneV520Display.clear();
    }
}

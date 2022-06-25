package oop.inheritance.operation.devices.displays;

import oop.inheritance.operation.Display;
import oop.library.vx520.VerifoneVx520Display;

public class Verifone520Display implements Display {

    private VerifoneVx520Display verifoneV520Display = new VerifoneVx520Display();

    public Verifone520Display() {

    }

    private static final class UniqueInstanceHolder {
        private static final Verifone520Display uniqueInstance = new Verifone520Display();
    }

    public static Verifone520Display getInstance() {
        return UniqueInstanceHolder.uniqueInstance;
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

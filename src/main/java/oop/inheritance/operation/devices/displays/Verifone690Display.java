package oop.inheritance.operation.devices.displays;

import oop.inheritance.operation.Display;
import oop.library.vx690.VerifoneVx690Display;

public class Verifone690Display implements Display {
    private VerifoneVx690Display verifoneV690Display = new VerifoneVx690Display();

    public Verifone690Display() {

    }

    private static final class UniqueInstanceHolder {
        private static final Verifone690Display uniqueInstance = new Verifone690Display();
    }

    public static Verifone690Display getInstance() {
        return UniqueInstanceHolder.uniqueInstance;
    }

    @Override
    public void showMessage(int x, int y, String message) {
        verifoneV690Display.showMessage(x, y, message);
    }

    @Override
    public void clear() {
        verifoneV690Display.clear();
    }
}

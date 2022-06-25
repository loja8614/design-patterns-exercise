package oop.inheritance.operation.devices.displays;

import oop.inheritance.operation.Display;
import oop.library.v240m.VerifoneV240mDisplay;

public class Verifone240mDisplay implements Display {
    private VerifoneV240mDisplay verifoneV240mDisplay = new VerifoneV240mDisplay();

    public Verifone240mDisplay() {

    }

    private static final class UniqueInstanceHolder {
        private static final Verifone240mDisplay uniqueInstance = new Verifone240mDisplay();
    }

    public static Verifone240mDisplay getInstance() {
        return UniqueInstanceHolder.uniqueInstance;
    }

    @Override
    public void showMessage(int x, int y, String message) {
        verifoneV240mDisplay.print(x, y, message);
    }

    @Override
    public void clear() {
        verifoneV240mDisplay.clear();
    }
}

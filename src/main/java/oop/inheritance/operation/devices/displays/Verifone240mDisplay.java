package oop.inheritance.operation.devices.displays;

import oop.inheritance.operation.Display;
import oop.library.v240m.VerifoneV240mDisplay;

public class Verifone240mDisplay implements Display {

    private VerifoneV240mDisplay verifoneV240mDisplay = new VerifoneV240mDisplay();

    private Verifone240mDisplay() {

    }

    private static Verifone240mDisplay uniqueInstance;

    public static Verifone240mDisplay getInstance() {
        if (uniqueInstance == null) {
            synchronized (Verifone240mDisplay.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Verifone240mDisplay();
                }
            }
        }

        return uniqueInstance;
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

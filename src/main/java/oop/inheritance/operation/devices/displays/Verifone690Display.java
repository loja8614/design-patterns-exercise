package oop.inheritance.operation.devices.displays;

import oop.inheritance.operation.Display;
import oop.library.vx690.VerifoneVx690Display;

public class Verifone690Display implements Display {
    private VerifoneVx690Display verifoneV690Display = new VerifoneVx690Display();

    private Verifone690Display() {

    }

    private static Verifone690Display uniqueInstance;


    public static Verifone690Display getInstance() {
        if (uniqueInstance == null) {
            synchronized (VerifoneVx690Display.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Verifone690Display();
                }
            }
        }

        return uniqueInstance;
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

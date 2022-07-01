package oop.inheritance.operation.devices.displays;


import oop.inheritance.operation.Display;

public class IngenicoDisplay implements Display {
    private oop.library.ingenico.services.IngenicoDisplay ingenicoDisplay = new oop.library.ingenico.services.IngenicoDisplay();

    private IngenicoDisplay() {

    }

    private static IngenicoDisplay uniqueInstance;

    public static IngenicoDisplay getInstance() {

        if (uniqueInstance == null) {
            synchronized (IngenicoDisplay.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new IngenicoDisplay();
                }
            }

        }
        return uniqueInstance;
    }

    @Override
    public void showMessage(int x, int y, String message) {
        ingenicoDisplay.showMessage(x, y, message);
    }

    @Override
    public void clear() {
        ingenicoDisplay.clear();
    }

}

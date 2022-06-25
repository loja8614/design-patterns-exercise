package oop.inheritance.operation.devices.displays;


import oop.inheritance.operation.Display;

public class IngenicoDisplay implements Display {
    private oop.library.ingenico.services.IngenicoDisplay ingenicoDisplay = new oop.library.ingenico.services.IngenicoDisplay();

    public IngenicoDisplay(){

    }

    private static final class UniqueInstanceHolder{
        private static final IngenicoDisplay uniqueInstance = new IngenicoDisplay();
    }
    public static IngenicoDisplay getInstance(){
        return UniqueInstanceHolder.uniqueInstance;
    }

    @Override
    public void showMessage(int x, int y, String message) {
        ingenicoDisplay.showMessage(x,y,message);
    }

    @Override
    public void clear() {
        ingenicoDisplay.clear();
    }

}

package oop.inheritance.implement;

import oop.inheritance.factories.ITerminal;
import oop.library.ingenico.services.IngenicoDisplay;
import oop.library.ingenico.services.IngenicoKeyboard;

public class Ingenico implements ITerminal {


    @Override
    public String readKey() {
        IngenicoKeyboard ingenicoKeyboard = new IngenicoKeyboard();
        return ingenicoKeyboard.getChar();
    }

    @Override
    public void showMenu() {
        IngenicoDisplay ingenicoDisplay = new IngenicoDisplay();
        ingenicoDisplay.showMessage(5, 5, "MENU");
        ingenicoDisplay.showMessage(5, 10, "1. VENTA");
        ingenicoDisplay.showMessage(5, 13, "2. DEVOLUCION");
        ingenicoDisplay.showMessage(5, 16, "3. REPORTE");
        ingenicoDisplay.showMessage(5, 23, "4. CONFIGURACION");
    }

    @Override
    public void doSale() {

    }

    @Override
    public void clearScreen() {
        IngenicoDisplay ingenicoDisplay = new IngenicoDisplay();
        ingenicoDisplay.clear();
    }

    @Override
    public void printReceipt() {

    }

    @Override
    public void sendSale() {

    }
}

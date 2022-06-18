package oop.inheritance.implement;

import oop.inheritance.factories.ITerminal;
import oop.library.vx690.VerifoneVx690Display;
import oop.library.vx690.VerifoneVx690Keyboard;

public class Verifone690 implements ITerminal {
    VerifoneVx690Display verifoneV690Display = new VerifoneVx690Display();
    @Override
    public String readKey() {
        VerifoneVx690Keyboard verifoneKeyboard= new VerifoneVx690Keyboard();
        return verifoneKeyboard.get();
    }

    @Override
    public void showMenu() {
        verifoneV690Display.showMessage(5, 5, "MENU");
        verifoneV690Display.showMessage(5, 10, "1. VENTA");
        verifoneV690Display.showMessage(5, 13, "2. DEVOLUCION");
        verifoneV690Display.showMessage(5, 16, "3. REPORTE");
        verifoneV690Display.showMessage(5, 23, "4. CONFIGURACION");
    }

    @Override
    public void doSale() {

    }

    @Override
    public void clearScreen() {
        verifoneV690Display.clear();
    }

    @Override
    public void printReceipt() {

    }

    @Override
    public void sendSale() {

    }
}

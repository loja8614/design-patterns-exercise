package oop.inheritance.implement;

import oop.inheritance.factories.ITerminal;
import oop.library.vx520.VerifoneVx520Display;
import oop.library.vx520.VerifoneVx520Keyboard;

public class Verifone520 implements ITerminal {
    VerifoneVx520Display verifoneV520Display = new VerifoneVx520Display();

    @Override
    public String readKey() {
        VerifoneVx520Keyboard verifoneKeyboard= new VerifoneVx520Keyboard();
        return verifoneKeyboard.get();
    }

    @Override
    public void showMenu() {
        verifoneV520Display.showMessage("MENU", 5, 5);
        verifoneV520Display.showMessage("1. VENTA", 5, 10);
        verifoneV520Display.showMessage("2. DEVOLUCION", 5, 13);
        verifoneV520Display.showMessage("3. REPORTE", 5, 16);
        verifoneV520Display.showMessage("4. CONFIGURACION", 5, 23);
    }

    @Override
    public void doSale() {

    }

    @Override
    public void clearScreen() {
        verifoneV520Display.clear();
    }


}

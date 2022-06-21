package oop.inheritance.implement;

import oop.inheritance.factories.ITerminal;
import oop.library.v240m.VerifoneV240mCardSwipper;
import oop.library.v240m.VerifoneV240mChipReader;
import oop.library.v240m.VerifoneV240mDisplay;
import oop.library.v240m.VerifoneV240mKeyboard;

public class Verifone240 implements ITerminal {

    VerifoneV240mDisplay verifoneV240mDisplay = new VerifoneV240mDisplay();

    @Override
    public String readKey() {
        VerifoneV240mKeyboard verifoneKeyboard = new VerifoneV240mKeyboard();
        return verifoneKeyboard.get();

    }

    @Override
    public void showMenu() {
        verifoneV240mDisplay.print(5, 5, "MENU");
        verifoneV240mDisplay.print(5, 10, "1. VENTA");
        verifoneV240mDisplay.print(5, 13, "2. DEVOLUCION");
        verifoneV240mDisplay.print(5, 16, "3. REPORTE");
        verifoneV240mDisplay.print(5, 23, "4. CONFIGURACION");
    }

    @Override
    public void doSale() {
        VerifoneV240mCardSwipper cardSwipper = new VerifoneV240mCardSwipper();
        VerifoneV240mChipReader chipReader = new VerifoneV240mChipReader();
        VerifoneV240mDisplay verifoneDisplay = new VerifoneV240mDisplay();
        VerifoneV240mKeyboard verifoneKeyboard = new VerifoneV240mKeyboard();



    }

    @Override
    public void clearScreen() {
        verifoneV240mDisplay.clear();
    }


}

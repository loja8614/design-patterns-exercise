package oop.inheritance.operation.devices.keyBoard;

import oop.inheritance.operation.KeyBoard;
import oop.library.v240m.VerifoneV240mKeyboard;

public class Verifone240mKeyBoard implements KeyBoard {
    private VerifoneV240mKeyboard verifoneKeyboard = new VerifoneV240mKeyboard();

    private Verifone240mKeyBoard() {

    }

    private static Verifone240mKeyBoard uniqueInstance;

    public static Verifone240mKeyBoard getInstance() {
        if (uniqueInstance == null) {
            synchronized (Verifone240mKeyBoard.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Verifone240mKeyBoard();
                }
            }
        }
        return uniqueInstance;
    }

    @Override
    public String getKeyChar() {

        return verifoneKeyboard.get();
    }

    @Override
    public String readLine() {
        return verifoneKeyboard.get();
    }
}

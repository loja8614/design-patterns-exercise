package oop.inheritance.operation.devices.keyBoard;

import oop.inheritance.operation.KeyBoard;
import oop.library.v240m.VerifoneV240mKeyboard;

public class Verifone240mKeyBoard implements KeyBoard {
    private VerifoneV240mKeyboard verifoneKeyboard = new VerifoneV240mKeyboard();

    public Verifone240mKeyBoard() {

    }

    private static final class UniqueInstanceHolder {
        private static final Verifone240mKeyBoard uniqueInstance = new Verifone240mKeyBoard();
    }

    public static Verifone240mKeyBoard getInstance() {
        return UniqueInstanceHolder.uniqueInstance;
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

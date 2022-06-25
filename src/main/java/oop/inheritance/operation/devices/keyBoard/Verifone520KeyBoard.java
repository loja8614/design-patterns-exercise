package oop.inheritance.operation.devices.keyBoard;

import oop.inheritance.operation.KeyBoard;
import oop.library.vx520.VerifoneVx520Keyboard;

public class Verifone520KeyBoard implements KeyBoard {
    private VerifoneVx520Keyboard verifoneKeyboard = new VerifoneVx520Keyboard();

    public Verifone520KeyBoard() {

    }

    private static final class UniqueInstanceHolder {
        private static final Verifone520KeyBoard uniqueInstance = new Verifone520KeyBoard();
    }

    public static Verifone520KeyBoard getInstance() {
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

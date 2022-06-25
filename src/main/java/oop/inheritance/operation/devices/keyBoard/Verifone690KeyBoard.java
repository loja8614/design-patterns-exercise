package oop.inheritance.operation.devices.keyBoard;

import oop.inheritance.operation.KeyBoard;
import oop.library.vx690.VerifoneVx690Keyboard;


public class Verifone690KeyBoard implements KeyBoard {

    private VerifoneVx690Keyboard verifoneKeyboard = new VerifoneVx690Keyboard();

    public Verifone690KeyBoard() {

    }

    private static final class UniqueInstanceHolder {
        private static final Verifone690KeyBoard uniqueInstance = new Verifone690KeyBoard();
    }

    public static Verifone690KeyBoard getInstance() {
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

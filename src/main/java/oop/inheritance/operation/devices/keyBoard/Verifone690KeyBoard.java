package oop.inheritance.operation.devices.keyBoard;

import oop.inheritance.operation.KeyBoard;
import oop.library.vx690.VerifoneVx690Keyboard;


public class Verifone690KeyBoard implements KeyBoard {

    private VerifoneVx690Keyboard verifoneKeyboard = new VerifoneVx690Keyboard();

    private Verifone690KeyBoard() {

    }

    private static Verifone690KeyBoard uniqueInstance;

    public static Verifone690KeyBoard getInstance() {
        if (uniqueInstance == null) {
            synchronized (Verifone690KeyBoard.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Verifone690KeyBoard();
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

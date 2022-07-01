package oop.inheritance.operation.devices.keyBoard;

import oop.inheritance.operation.KeyBoard;
import oop.library.vx520.VerifoneVx520Keyboard;

public class Verifone520KeyBoard implements KeyBoard {
    private VerifoneVx520Keyboard verifoneKeyboard = new VerifoneVx520Keyboard();

    private Verifone520KeyBoard() {

    }

    private static Verifone520KeyBoard uniqueInstance;

    public static Verifone520KeyBoard getInstance() {
        if (uniqueInstance == null) {
            synchronized (Verifone520KeyBoard.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Verifone520KeyBoard();
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

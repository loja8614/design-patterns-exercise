package oop.inheritance.operation.devices.keyBoard;

import oop.inheritance.operation.KeyBoard;
import oop.library.ingenico.services.IngenicoKeyboard;

public class IngenicoKeyBoard implements KeyBoard {

    private IngenicoKeyboard ingenicoKeyboard = new IngenicoKeyboard();

    public IngenicoKeyBoard() {

    }

    private static final class UniqueInstanceHolder {
        private static final IngenicoKeyBoard uniqueInstance = new IngenicoKeyBoard();
    }

    public static IngenicoKeyBoard getInstance() {
        return UniqueInstanceHolder.uniqueInstance;
    }

    @Override
    public String getKeyChar() {
        return ingenicoKeyboard.getChar();
    }

    @Override
    public String readLine() {
        return ingenicoKeyboard.readLine();
    }
}

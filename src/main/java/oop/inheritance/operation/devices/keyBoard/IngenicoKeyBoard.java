package oop.inheritance.operation.devices.keyBoard;

import oop.inheritance.operation.KeyBoard;
import oop.library.ingenico.services.IngenicoKeyboard;

public class IngenicoKeyBoard implements KeyBoard {

    private IngenicoKeyboard ingenicoKeyboard = new IngenicoKeyboard();

    private IngenicoKeyBoard() {

    }

    private static IngenicoKeyBoard uniqueInstance;

    public static IngenicoKeyBoard getInstance() {
        if(uniqueInstance ==null){
            synchronized (IngenicoKeyBoard.class){
                if(uniqueInstance ==null){
                    uniqueInstance=new IngenicoKeyBoard();
                }
            }
        }
        return uniqueInstance;
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

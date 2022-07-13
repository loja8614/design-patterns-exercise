package oop.inheritance.factories;


import oop.inheritance.enums.CommunicationType;
import oop.inheritance.operation.CardProvider;
import oop.inheritance.operation.Display;
import oop.inheritance.operation.KeyBoard;
import oop.inheritance.operation.Printer;
import oop.inheritance.operation.connection.Communication;
import oop.inheritance.operation.connection.verifone520.Verifone520Ethernet;
import oop.inheritance.operation.connection.verifone520.Verifone520Gps;
import oop.inheritance.operation.connection.verifone520.Verifone520Modem;
import oop.inheritance.operation.devices.reader.Verifone520CardProvider;
import oop.inheritance.operation.devices.keyBoard.Verifone520KeyBoard;
import oop.inheritance.operation.devices.displays.Verifone520Display;
import oop.inheritance.operation.devices.print.Verifone520Printer;

public class Verifone520Factory extends TerminalFactory {

    @Override
    public Display getDisplay() {
        return Verifone520Display.getInstance();
    }

    @Override
    public KeyBoard getKeyBoard() {
        return Verifone520KeyBoard.getInstance();
    }

    @Override
    public Printer printer() {
        return Verifone520Printer.getInstance();
    }

    @Override
    public CardProvider cardReader() {
        return Verifone520CardProvider.getInstance();
    }

    @Override
    public Communication getConnection(CommunicationType communicationType) {
        switch (communicationType) {
            case GPS:
                return Verifone520Gps.getInstance();
            case MODEM:
                return Verifone520Modem.getInstance();
            default:
                return Verifone520Ethernet.getInstance();
        }
    }
}

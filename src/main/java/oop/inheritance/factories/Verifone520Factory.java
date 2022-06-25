package oop.inheritance.factories;


import oop.inheritance.data.CommunicationType;
import oop.inheritance.operation.ChipReader;
import oop.inheritance.operation.Display;
import oop.inheritance.operation.KeyBoard;
import oop.inheritance.operation.Printer;
import oop.inheritance.operation.connection.Communication;
import oop.inheritance.operation.connection.verifone520.Verifone520Ethernet;
import oop.inheritance.operation.connection.verifone520.Verifone520Gps;
import oop.inheritance.operation.connection.verifone520.Verifone520Modem;
import oop.inheritance.operation.devices.chipReader.Verifone520ChipReader;
import oop.inheritance.operation.devices.keyBoard.Verifone520KeyBoard;
import oop.inheritance.operation.devices.displays.Verifone520Display;
import oop.inheritance.operation.devices.print.Verifone520Printer;

public class Verifone520Factory extends TerminalFactory {

    @Override
    public Display getDisplay() {
        return new Verifone520Display();
    }

    @Override
    public KeyBoard getKeyBoard() {
        return new Verifone520KeyBoard();
    }

    @Override
    public Printer printer() {
        return new Verifone520Printer();
    }

    @Override
    public ChipReader chipReader() {
        return new Verifone520ChipReader();
    }

    @Override
    public Communication getConnection(CommunicationType communicationType) {
        switch (communicationType) {
            case GPS:
                return new Verifone520Gps();
            case MODEM:
                return new Verifone520Modem();
            default:
                return new Verifone520Ethernet();
        }
    }
}

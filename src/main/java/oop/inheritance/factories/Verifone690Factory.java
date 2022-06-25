package oop.inheritance.factories;

import oop.inheritance.data.CommunicationType;
import oop.inheritance.operation.ChipReader;
import oop.inheritance.operation.Display;
import oop.inheritance.operation.KeyBoard;
import oop.inheritance.operation.Printer;
import oop.inheritance.operation.connection.Communication;
import oop.inheritance.operation.connection.verifone690.Verifone690Ethernet;
import oop.inheritance.operation.connection.verifone690.Verifone690Gps;
import oop.inheritance.operation.connection.verifone690.Verifone690Modem;
import oop.inheritance.operation.devices.chipReader.Verifone690ChipReader;
import oop.inheritance.operation.devices.keyBoard.Verifone690KeyBoard;
import oop.inheritance.operation.devices.displays.Verifone690Display;
import oop.inheritance.operation.devices.print.Verifone690Printer;

public class Verifone690Factory extends TerminalFactory {
    @Override
    public Display getDisplay() {
        return new Verifone690Display();
    }

    @Override
    public KeyBoard getKeyBoard() {
        return new Verifone690KeyBoard();
    }

    @Override
    public Printer printer() {
        return new Verifone690Printer();
    }

    @Override
    public ChipReader chipReader() {
        return new Verifone690ChipReader();
    }

    @Override
    public Communication getConnection(CommunicationType communicationType) {
        switch (communicationType) {
            case GPS:
                return new Verifone690Gps();
            case MODEM:
                return new Verifone690Modem();
            default:
                return new Verifone690Ethernet();
        }
    }
}

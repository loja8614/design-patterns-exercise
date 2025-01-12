package oop.inheritance.factories;

import oop.inheritance.enums.CommunicationType;
import oop.inheritance.operation.CardProvider;
import oop.inheritance.operation.Display;
import oop.inheritance.operation.KeyBoard;
import oop.inheritance.operation.Printer;
import oop.inheritance.operation.connection.Communication;
import oop.inheritance.operation.connection.verifone690.Verifone690Ethernet;
import oop.inheritance.operation.connection.verifone690.Verifone690Gps;
import oop.inheritance.operation.connection.verifone690.Verifone690Modem;
import oop.inheritance.operation.devices.reader.Verifone690CardProvider;
import oop.inheritance.operation.devices.keyBoard.Verifone690KeyBoard;
import oop.inheritance.operation.devices.displays.Verifone690Display;
import oop.inheritance.operation.devices.print.Verifone690Printer;

public class Verifone690Factory extends TerminalFactory {
    @Override
    public Display getDisplay() {
        return Verifone690Display.getInstance();
    }

    @Override
    public KeyBoard getKeyBoard() {
        return Verifone690KeyBoard.getInstance();
    }

    @Override
    public Printer printer() {
        return Verifone690Printer.getInstance();
    }

    @Override
    public CardProvider cardReader() {
        return Verifone690CardProvider.getInstance();
    }

    @Override
    public Communication getConnection(CommunicationType communicationType) {
        switch (communicationType) {
            case GPS:
                return Verifone690Gps.getInstance();
            case MODEM:
                return Verifone690Modem.getInstance();
            default:
                return Verifone690Ethernet.getInstance();
        }
    }
}

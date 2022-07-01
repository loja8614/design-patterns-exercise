package oop.inheritance.factories;

import oop.inheritance.data.CommunicationType;
import oop.inheritance.operation.ChipReader;
import oop.inheritance.operation.Display;
import oop.inheritance.operation.KeyBoard;
import oop.inheritance.operation.Printer;
import oop.inheritance.operation.connection.Communication;
import oop.inheritance.operation.connection.verifone240.Verifone240Ethernet;
import oop.inheritance.operation.connection.verifone240.Verifone240Gps;
import oop.inheritance.operation.connection.verifone240.Verifone240Modem;
import oop.inheritance.operation.devices.chipReader.Verifone240ChipReader;
import oop.inheritance.operation.devices.keyBoard.Verifone240mKeyBoard;
import oop.inheritance.operation.devices.displays.Verifone240mDisplay;
import oop.inheritance.operation.devices.print.Verifone240mPrinter;

public class Verifone240Factory extends TerminalFactory {

    @Override
    public Display getDisplay() {
        return Verifone240mDisplay.getInstance();
    }

    @Override
    public KeyBoard getKeyBoard() {
        return Verifone240mKeyBoard.getInstance();
    }

    @Override
    public Printer printer() {
        return Verifone240mPrinter.getInstance();
    }

    @Override
    public ChipReader chipReader() {
        return Verifone240ChipReader.getInstance();
    }

    @Override
    public Communication getConnection(CommunicationType communicationType) {
        switch (communicationType) {
            case GPS:
                return Verifone240Gps.getInstance();
            case MODEM:
                return Verifone240Modem.getInstance();
            default:
                return Verifone240Ethernet.getInstance();
        }
    }
}

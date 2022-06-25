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
        return new Verifone240mDisplay();
    }

    @Override
    public KeyBoard getKeyBoard() {
        return new Verifone240mKeyBoard();
    }

    @Override
    public Printer printer() {
        return new Verifone240mPrinter();
    }

    @Override
    public ChipReader chipReader() {
        return new Verifone240ChipReader();
    }

    @Override
    public Communication getConnection(CommunicationType communicationType) {
        switch (communicationType) {
            case GPS:
                return new Verifone240Gps();
            case MODEM:
                return new Verifone240Modem();
            default:
                return new Verifone240Ethernet();
        }
    }
}

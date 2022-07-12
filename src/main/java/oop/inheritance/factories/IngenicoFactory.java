package oop.inheritance.factories;

import oop.inheritance.enums.CommunicationType;
import oop.inheritance.operation.ChipReader;
import oop.inheritance.operation.Display;
import oop.inheritance.operation.Printer;
import oop.inheritance.operation.connection.Communication;

import oop.inheritance.operation.connection.ingenico.IngenicoEthernet;
import oop.inheritance.operation.connection.ingenico.IngenicoGps;
import oop.inheritance.operation.connection.ingenico.IngenicoModem;
import oop.inheritance.operation.devices.chipReader.IngenicoChipReader;
import oop.inheritance.operation.devices.keyBoard.IngenicoKeyBoard;
import oop.inheritance.operation.devices.displays.IngenicoDisplay;
import oop.inheritance.operation.KeyBoard;
import oop.inheritance.operation.devices.print.IngenicoPrinter;

public class IngenicoFactory extends TerminalFactory{

    public Display getDisplay() {
         return  IngenicoDisplay.getInstance();
    }

    @Override
    public KeyBoard getKeyBoard() {
        return IngenicoKeyBoard.getInstance();
    }

    @Override
    public Printer printer() {
        return IngenicoPrinter.getInstance();
    }

    @Override
    public ChipReader chipReader() {
        return IngenicoChipReader.getInstance();
    }

    @Override
    public Communication getConnection(CommunicationType communicationType) {

        switch (communicationType) {
            case GPS:
                return  IngenicoGps.getInstance();
            case MODEM:
                return  IngenicoModem.getInstance();
            default:
                return IngenicoEthernet.getInstance();
        }



    }


}

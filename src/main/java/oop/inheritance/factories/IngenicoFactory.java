package oop.inheritance.factories;

import oop.inheritance.data.CommunicationType;
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
         return  new  IngenicoDisplay();
    }

    @Override
    public KeyBoard getKeyBoard() {
        return new IngenicoKeyBoard();
    }

    @Override
    public Printer printer() {
        return new IngenicoPrinter();
    }

    @Override
    public ChipReader chipReader() {
        return new IngenicoChipReader();
    }

    @Override
    public Communication getConnection(CommunicationType communicationType) {

        switch (communicationType) {
            case GPS:
                return  new IngenicoGps();
            case MODEM:
                return  new IngenicoModem();
            default:
                return new IngenicoEthernet();
        }



    }


}

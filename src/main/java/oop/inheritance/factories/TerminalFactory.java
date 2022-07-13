package oop.inheritance.factories;

import oop.inheritance.enums.CommunicationType;
import oop.inheritance.enums.SupportedTerminal;
import oop.inheritance.operation.CardProvider;
import oop.inheritance.operation.Display;
import oop.inheritance.operation.KeyBoard;
import oop.inheritance.operation.Printer;
import oop.inheritance.operation.connection.Communication;

public abstract class TerminalFactory  {

    public static TerminalFactory getInstance( SupportedTerminal supportedTerminal ){

        switch (supportedTerminal){
            case VERIFONE240:
                return new Verifone240Factory();
            case VERIFONE520:
                return new Verifone520Factory();
            case VERIFONE690:
                return new Verifone690Factory();
            default:
                return new IngenicoFactory();
        }
    }

    public abstract Display getDisplay();

    public abstract KeyBoard getKeyBoard();

    public abstract Printer printer();

    public abstract CardProvider cardReader();

    public abstract Communication getConnection(CommunicationType communicationType);



}

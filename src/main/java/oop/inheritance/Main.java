package oop.inheritance;

import oop.inheritance.data.CommunicationType;
import oop.inheritance.data.SupportedTerminal;
import oop.inheritance.factories.*;

public class Main {

    public static void main(String[] args) {

        SupportedTerminal supportedTerminal = SupportedTerminal.INGENICO;
        CommunicationType communicationType = CommunicationType.ETHERNET;

        TerminalFactory factory;

        if(SupportedTerminal.INGENICO == supportedTerminal ){
            factory = new IngenicoFactory();
        }else if(SupportedTerminal.VERIFONE240 == supportedTerminal){
            factory = new Verifone240Factory();
        }else if(SupportedTerminal.VERIFONE520 == supportedTerminal){
            factory = new Verifone520Factory();
        }else if(SupportedTerminal.VERIFONE690 == supportedTerminal){
            factory = new Verifone690Factory();
        }else
        {
            factory = new IngenicoFactory();
            System.out.println("There is not terminal supported The transaction will be Ingenico ");
        }

        Application application = Application.getInstance(factory,communicationType);

        while (true) {
            run(application);
        }
    }

    public static void run(Application application) {
        application.clearScreen();
        application.showMenu();

        String key = application.readKey();

        switch (key) {
            case "1":
                application.doSale();
                break;
            case "2":
                application.doRefund();
                break;
            case "3":
                application.printReport();
                break;
            case "4":
                application.showConfiguration();
                break;
        }
    }

}

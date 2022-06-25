package oop.inheritance;

import oop.inheritance.data.CommunicationType;
import oop.inheritance.data.SupportedTerminal;
import oop.inheritance.factories.*;

public class Main {

    public static void main(String[] args) {

        SupportedTerminal supportedTerminal = SupportedTerminal.INGENICO;
        CommunicationType communicationType = CommunicationType.ETHERNET;

        TerminalFactory factory = TerminalFactory.getInstance(supportedTerminal);
        Application application = new Application(factory, communicationType);

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

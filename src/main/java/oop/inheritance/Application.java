package oop.inheritance;

import oop.inheritance.data.CommunicationType;
import oop.inheritance.factories.TerminalFactory;

public class Application {

    private static Application application;
    private CommunicationType communicationType;
    private TerminalFactory factory;

    private Application(TerminalFactory factory, CommunicationType communicationType) {
        this.factory = factory;
        this.communicationType = communicationType;
    }

    public static Application getInstance(TerminalFactory factory, CommunicationType communicationType) {
        if (application == null) {
            application = new Application(factory, communicationType);
        } else {
            System.out.println("There is a current active instance of Application");
        }
        return application;
    }

    public void showMenu() {
        factory.createTerminal().showMenu();
    }

    public String readKey() {
        return factory.createTerminal().readKey();
    }

    public void doSale() {
        factory.createTerminal().doSale();
    }

    public void doRefund() {
    }

    public void printReport() {
    }

    public void showConfiguration() {
    }

    public void clearScreen() {
        factory.createTerminal().clearScreen();
    }
}

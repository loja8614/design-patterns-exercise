package oop.inheritance;

import java.time.LocalDateTime;

import oop.inheritance.data.CommunicationType;
import oop.inheritance.data.SupportedTerminal;
import oop.inheritance.factories.TerminalFactory;
import oop.inheritance.transaction.TransactionBuilder;
import oop.library.ingenico.model.Card;
import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.model.TransactionResponse;
import oop.library.ingenico.services.*;
import oop.library.v240m.VerifoneV240mDisplay;

public class Application {

    private static Application application;
    private CommunicationType communicationType = CommunicationType.ETHERNET;
    private TerminalFactory factory;

    private Application(TerminalFactory factory) {
        this.factory = factory;
    }

    public static Application getInstance(TerminalFactory factory) {
        if (application == null) {
            application = new Application(factory);
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

        //Esta construcción con estategy
        IngenicoCardSwipper cardSwipper = new IngenicoCardSwipper();
        IngenicoChipReader chipReader = new IngenicoChipReader();
        IngenicoDisplay ingenicoDisplay = new IngenicoDisplay();
        IngenicoKeyboard ingenicoKeyboard = new IngenicoKeyboard();
        Card card;

        //modificar para instruccion lambda o flecha
        do {
            card = cardSwipper.readCard();
            if (card == null) {
                card = chipReader.readCard();
            }
        } while (card == null);


        ingenicoDisplay.clear();
        ingenicoDisplay.showMessage(5, 20, "Capture monto:");

        String amount = ingenicoKeyboard.readLine(); //Amount with decimal point as string

        TransactionBuilder builder = new TransactionBuilder(card);
        Transaction transaction = builder.amountInCents(Integer.parseInt(amount.replace(".", ""))).localTime(LocalDateTime.now()).build();
        TransactionResponse response = sendSale(transaction);

        if (response.isApproved()) {
            ingenicoDisplay.showMessage(5, 25, "APROBADA");
            printReceipt(transaction, response.getHostReference());
        } else {
            ingenicoDisplay.showMessage(5, 25, "DENEGADA");
        }
    }

    private void printReceipt(Transaction transaction, String hostReference) {
        IngenicoPrinter ingenicoPrinter = new IngenicoPrinter();
        Card card = transaction.getCard();

        ingenicoPrinter.print(5, "APROBADA");
        ingenicoPrinter.lineFeed();
        ingenicoPrinter.print(5, card.getAccount());
        ingenicoPrinter.lineFeed();
        ingenicoPrinter.print(5, "" + transaction.getAmountInCents());
        ingenicoPrinter.lineFeed();
        ingenicoPrinter.print(5, "________________");

    }

    private TransactionResponse sendSale(Transaction transaction) {
        IngenicoEthernet ethernet = new IngenicoEthernet();
        IngenicoModem modem = new IngenicoModem();
        IngenicoGPS gps = new IngenicoGPS();
        TransactionResponse transactionResponse = null;

        switch (communicationType) {
            case ETHERNET:
                ethernet.open();
                ethernet.send(transaction);
                transactionResponse = ethernet.receive();
                ethernet.close();
                break;
            case GPS:
                gps.open();
                gps.send(transaction);
                transactionResponse = gps.receive();
                gps.close();
                break;
            case MODEM:
                modem.open();
                modem.send(transaction);
                transactionResponse = modem.receive();
                modem.close();
                break;
        }

        return transactionResponse;
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

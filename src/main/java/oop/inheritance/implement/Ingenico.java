package oop.inheritance.implement;

import oop.inheritance.data.CommunicationType;
import oop.inheritance.factories.ITerminal;
import oop.inheritance.strategies.ingenico.CommunicationByEthernet;
import oop.inheritance.strategies.ingenico.CommunicationByGps;
import oop.inheritance.strategies.ingenico.CommunicationByModem;
import oop.inheritance.strategies.CommunicationStrategy;
import oop.inheritance.transaction.TransactionBuilder;
import oop.library.ingenico.model.Card;
import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.model.TransactionResponse;
import oop.library.ingenico.services.*;

import java.time.LocalDateTime;

public class Ingenico implements ITerminal {


    @Override
    public String readKey() {
        IngenicoKeyboard ingenicoKeyboard = new IngenicoKeyboard();
        return ingenicoKeyboard.getChar();
    }

    @Override
    public void showMenu() {
        IngenicoDisplay ingenicoDisplay = new IngenicoDisplay();
        ingenicoDisplay.showMessage(5, 5, "MENU");
        ingenicoDisplay.showMessage(5, 10, "1. VENTA");
        ingenicoDisplay.showMessage(5, 13, "2. DEVOLUCION");
        ingenicoDisplay.showMessage(5, 16, "3. REPORTE");
        ingenicoDisplay.showMessage(5, 23, "4. CONFIGURACION");
    }

    @FunctionalInterface
    public interface CardProvider{
        Card readCard(Card card);
    }

    public static void doReadCard(CardProvider card){
        IngenicoChipReader chipReader = new IngenicoChipReader();
        card.readCard(chipReader.readCard());
    }

    @Override
    public void doSale() {
        IngenicoChipReader chipReader = new IngenicoChipReader();
        IngenicoDisplay ingenicoDisplay = new IngenicoDisplay();
        IngenicoKeyboard ingenicoKeyboard = new IngenicoKeyboard();

        Card card;

        CardProvider card1 = (p) -> {
          return p;
        };

        do {
            card=chipReader.readCard();
            if (card == null) {
                card = chipReader.readCard();
            }

        } while (card == null);


        ingenicoDisplay.clear();
        ingenicoDisplay.showMessage(5, 20, "Capture monto:");

        String amount = ingenicoKeyboard.readLine(); //Amount with decimal point as string

        TransactionBuilder builder = new TransactionBuilder(card);
        Transaction transaction = builder.amountInCents(Integer.parseInt(amount.replace(".", ""))).localTime(LocalDateTime.now()).build();

        TransactionResponse response = sendSale(transaction, CommunicationType.ETHERNET);

        if (response.isApproved()) {
            ingenicoDisplay.showMessage(5, 25, "APROBADA");
            printReceipt(transaction);
        } else {
            ingenicoDisplay.showMessage(5, 25, "DENEGADA");
        }
    }

    @Override
    public void clearScreen() {
        IngenicoDisplay ingenicoDisplay = new IngenicoDisplay();
        ingenicoDisplay.clear();
    }

    private void printReceipt(Transaction transaction) {
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

    private TransactionResponse sendSale(Transaction transaction, CommunicationType communicationType) {
        CommunicationStrategy strategy;
        if (communicationType == CommunicationType.ETHERNET) {
            strategy = new CommunicationByEthernet();
        } else if (communicationType == CommunicationType.GPS) {
            strategy = new CommunicationByGps();
        } else {
            strategy = new CommunicationByModem();
        }
        return strategy.createCommunication(transaction);
    }
}

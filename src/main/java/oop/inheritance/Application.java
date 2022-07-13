package oop.inheritance;

import oop.inheritance.enums.CommunicationType;
import oop.inheritance.factories.TerminalFactory;
import oop.inheritance.model.CardDTO;
import oop.inheritance.operation.CardProvider;
import oop.inheritance.operation.Display;
import oop.inheritance.operation.KeyBoard;
import oop.inheritance.operation.Printer;
import oop.inheritance.operation.connection.Communication;
import oop.inheritance.model.TransactionDTO;
import oop.inheritance.transaction.TransactionBuilder;
import oop.inheritance.model.TransactionResponseDTO;

import java.time.LocalDateTime;

public class Application {

    private CommunicationType communicationType;
    private TerminalFactory factory;

    public Application(TerminalFactory factory, CommunicationType communicationType) {
        this.factory = factory;
        this.communicationType = communicationType;
    }

    void showMenu() {
        Display display = factory.getDisplay();

        display.showMessage(5, 5, "MENU");
        display.showMessage(5, 10, "1. VENTA");
        display.showMessage(5, 13, "2. DEVOLUCION");
        display.showMessage(5, 16, "3. REPORTE");
        display.showMessage(5, 23, "4. CONFIGURACION");
    }

    String readKey() {
        KeyBoard keyBoard = factory.getKeyBoard();
        return keyBoard.getKeyChar();
    }


    void doSale() {
        Display display = factory.getDisplay();
        KeyBoard keyBoard = factory.getKeyBoard();
        CardProvider cardProvider = factory.cardReader();

        cardProvider.readCard(card->{
            display.clear();
            display.showMessage(5, 20, "Capture monto:");

            String amount = keyBoard.readLine(); //Amount with decimal point as string

            TransactionBuilder builder = new TransactionBuilder(card);
            TransactionDTO transaction = builder.amountInCents(Integer.parseInt(amount.replace(".", ""))).localTime(LocalDateTime.now()).build();
            TransactionResponseDTO response = sendSale(transaction, communicationType);

            if (response.isApproved()) {
                display.showMessage(5, 25, "APROBADA");
                printReceipt(transaction);
            } else {
                display.showMessage(5, 25, "DENEGADA");
            }
        });

    }

    private void printReceipt(TransactionDTO transaction) {
        Printer printer = factory.printer();
        CardDTO card = transaction.getCard();
        printer.print(5, "APROBADA");
        printer.lineFeed();
        printer.print(5, card.getAccount());
        printer.lineFeed();
        printer.print(5, "" + transaction.getAmountInCents());
        printer.lineFeed();
        printer.print(5, "________________");

    }

    private TransactionResponseDTO sendSale(TransactionDTO transaction, CommunicationType communicationType) {

        Communication communication = factory.getConnection(communicationType);

        TransactionResponseDTO transactionResponse;
        communication.open();
        communication.send(transaction);
        transactionResponse = communication.receive();
        communication.close();
        return transactionResponse;

    }

    void doRefund() {
    }

    void printReport() {
    }

    void showConfiguration() {
    }

    void clearScreen() {
        Display display = factory.getDisplay();
        display.clear();
    }
}

package oop.inheritance.strategies.ingenico;

import oop.inheritance.strategies.CommunicationStrategy;
import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.model.TransactionResponse;
import oop.library.ingenico.services.IngenicoModem;

public class CommunicationByModem implements CommunicationStrategy {
    @Override
    public TransactionResponse createCommunication(Transaction transaction) {
        IngenicoModem modem = new IngenicoModem();
        TransactionResponse transactionResponse = null;
        modem.open();
        modem.send(transaction);
        transactionResponse = modem.receive();
        modem.close();
        return transactionResponse;

    }
}

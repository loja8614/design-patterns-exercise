package oop.inheritance.strategies.ingenico;

import oop.inheritance.strategies.CommunicationStrategy;
import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.model.TransactionResponse;
import oop.library.ingenico.services.IngenicoGPS;

public class CommunicationByGps implements CommunicationStrategy {
    @Override
    public TransactionResponse createCommunication(Transaction transaction) {
        IngenicoGPS gps = new IngenicoGPS();
        TransactionResponse transactionResponse = null;
        gps.open();
        gps.send(transaction);
        transactionResponse = gps.receive();
        gps.close();
        return transactionResponse;
    }

}

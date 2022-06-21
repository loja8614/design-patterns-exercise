package oop.inheritance.strategies.verifone;

import oop.inheritance.strategies.CommunicationStrategy;
import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.model.TransactionResponse;
import oop.library.v240m.VerifoneV240mGPS;

public class CommunicationByGps implements CommunicationStrategy {
    @Override
    public TransactionResponse createCommunication(Transaction transaction) {
        VerifoneV240mGPS gps = new VerifoneV240mGPS();
        TransactionResponse transactionResponse = null;
        gps.open();
        //gps.send(transaction);
        //transactionResponse = gps.receive();
        gps.send(null);
        transactionResponse = null;
        gps.close();
        return transactionResponse;
    }
}

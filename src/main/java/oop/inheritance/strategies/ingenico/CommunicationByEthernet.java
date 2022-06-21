package oop.inheritance.strategies.ingenico;

import oop.inheritance.strategies.CommunicationStrategy;
import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.model.TransactionResponse;
import oop.library.ingenico.services.IngenicoEthernet;

public class CommunicationByEthernet implements CommunicationStrategy {
    @Override
    public TransactionResponse createCommunication(Transaction transaction) {
        TransactionResponse transactionResponse = null;
        IngenicoEthernet ethernet = new IngenicoEthernet();
        ethernet.open();
        ethernet.send(transaction);
        transactionResponse = ethernet.receive();
        ethernet.close();
        return transactionResponse;
    }
}

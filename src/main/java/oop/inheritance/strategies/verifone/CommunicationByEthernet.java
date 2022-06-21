package oop.inheritance.strategies.verifone;

import oop.inheritance.strategies.CommunicationStrategy;
import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.model.TransactionResponse;


public class CommunicationByEthernet implements CommunicationStrategy {
    @Override
    public TransactionResponse createCommunication(Transaction transaction) {
       return null;
    }
}

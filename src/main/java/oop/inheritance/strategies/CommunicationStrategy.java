package oop.inheritance.strategies;

import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.model.TransactionResponse;

public interface CommunicationStrategy {
    TransactionResponse createCommunication(Transaction transaction);
}

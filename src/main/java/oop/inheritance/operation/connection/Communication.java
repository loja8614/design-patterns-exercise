package oop.inheritance.operation.connection;

import oop.inheritance.model.Transaction;
import oop.inheritance.model.TransactionResponse;

public interface Communication {
    void open();
    void send(Transaction transaction);
    TransactionResponse receive();
    void close();
}

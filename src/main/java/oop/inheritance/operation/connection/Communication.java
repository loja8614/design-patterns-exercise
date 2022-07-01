package oop.inheritance.operation.connection;

import oop.inheritance.model.TransactionDTO;
import oop.inheritance.model.TransactionResponseDTO;

public interface Communication {
    void open();
    void send(TransactionDTO transaction);
    TransactionResponseDTO receive();
    void close();
}

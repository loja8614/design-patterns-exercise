package oop.inheritance.operation.connection.ingenico;

import oop.inheritance.operation.connection.Communication;
import oop.inheritance.model.Transaction;
import oop.inheritance.model.TransactionResponse;

public class IngenicoEthernet implements Communication {
    private IngenicoEthernet ethernet = new IngenicoEthernet();

    private static final class UniqueInstanceHolder {
        private static final IngenicoEthernet uniqueInstance = new IngenicoEthernet();
    }

    public static IngenicoEthernet getInstance() {
        return UniqueInstanceHolder.uniqueInstance;
    }

    @Override
    public void open() {
        ethernet.open();
    }

    @Override
    public void send(Transaction transaction) {
        ethernet.send(transaction);
    }

    @Override
    public TransactionResponse receive() {
        return ethernet.receive();
    }

    @Override
    public void close() {
        ethernet.close();
    }
}

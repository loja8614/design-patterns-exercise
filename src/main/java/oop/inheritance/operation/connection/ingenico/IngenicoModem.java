package oop.inheritance.operation.connection.ingenico;

import oop.inheritance.operation.connection.Communication;
import oop.inheritance.model.Transaction;
import oop.inheritance.model.TransactionResponse;

public class IngenicoModem implements Communication {
    private IngenicoModem modem = new IngenicoModem();

    private static final class UniqueInstanceHolder {
        private static final IngenicoModem uniqueInstance = new IngenicoModem();
    }

    public static IngenicoModem getInstance() {
        return UniqueInstanceHolder.uniqueInstance;
    }

    @Override
    public void open() {
        modem.open();
    }

    @Override
    public void send(Transaction transaction) {
        modem.send(transaction);
    }

    @Override
    public TransactionResponse receive() {
        return modem.receive();
    }

    @Override
    public void close() {
        modem.close();
    }
}

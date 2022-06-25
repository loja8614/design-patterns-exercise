package oop.inheritance.operation.connection.ingenico;

import oop.inheritance.operation.connection.Communication;
import oop.inheritance.model.Transaction;
import oop.inheritance.model.TransactionResponse;
import oop.library.ingenico.services.IngenicoGPS;

public class IngenicoGps implements Communication {
    private IngenicoGPS gps = new IngenicoGPS();

    private static final class UniqueInstanceHolder {
        private static final IngenicoGps uniqueInstance = new IngenicoGps();
    }

    public static IngenicoGps getInstance() {
        return UniqueInstanceHolder.uniqueInstance;
    }

    @Override
    public void open() {
        gps.open();
    }

    @Override
    public void send(Transaction transaction) {
        gps.send(transaction);
    }

    @Override
    public TransactionResponse receive() {
        return (TransactionResponse) gps.receive();
    }

    @Override
    public void close() {
        gps.close();
    }
}
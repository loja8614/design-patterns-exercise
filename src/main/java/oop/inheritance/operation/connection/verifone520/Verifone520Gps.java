package oop.inheritance.operation.connection.verifone520;

import oop.inheritance.operation.connection.Communication;
import oop.inheritance.model.Transaction;
import oop.inheritance.model.TransactionResponse;
import oop.inheritance.transaction.Serializer;
import oop.library.vx520.VerifoneVx520GPS;

public class Verifone520Gps implements Communication {
    private VerifoneVx520GPS verifoneVx520GPS = new VerifoneVx520GPS();


    private static final class UniqueInstanceHolder {
        private static final Verifone520Gps uniqueInstance = new Verifone520Gps();
    }

    public static Verifone520Gps getInstance() {
        return UniqueInstanceHolder.uniqueInstance;
    }

    @Override
    public void open() {
        verifoneVx520GPS.open();
    }

    @Override
    public void send(Transaction transaction) {
        verifoneVx520GPS.send(Serializer.serialize(transaction));
    }

    @Override
    public TransactionResponse receive() {
        return (TransactionResponse) Serializer.deserialize(verifoneVx520GPS.receive());
    }

    @Override
    public void close() {
        verifoneVx520GPS.close();
    }
}

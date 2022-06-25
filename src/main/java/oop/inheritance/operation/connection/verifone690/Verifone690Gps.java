package oop.inheritance.operation.connection.verifone690;

import oop.inheritance.operation.connection.Communication;
import oop.inheritance.model.Transaction;
import oop.inheritance.model.TransactionResponse;
import oop.inheritance.transaction.Serializer;
import oop.library.vx690.VerifoneVx690GPS;

public class Verifone690Gps implements Communication {
    private VerifoneVx690GPS verifoneVx690GPS = new VerifoneVx690GPS();

    private static final class UniqueInstanceHolder {
        private static final Verifone690Gps uniqueInstance = new Verifone690Gps();
    }

    public static Verifone690Gps getInstance() {
        return UniqueInstanceHolder.uniqueInstance;
    }

    @Override
    public void open() {
        verifoneVx690GPS.open();
    }

    @Override
    public void send(Transaction transaction) {
        verifoneVx690GPS.send(Serializer.serialize(transaction));
    }

    @Override
    public TransactionResponse receive() {
        return (TransactionResponse) Serializer.deserialize(verifoneVx690GPS.receive());
    }

    @Override
    public void close() {
        verifoneVx690GPS.close();
    }
}

package oop.inheritance.operation.connection.verifone520;

import oop.inheritance.operation.connection.Communication;
import oop.inheritance.model.Transaction;
import oop.inheritance.model.TransactionResponse;
import oop.inheritance.transaction.Serializer;
import oop.library.vx520.VerifoneVx520Ethernet;

public class Verifone520Ethernet implements Communication {
    private VerifoneVx520Ethernet verifoneVx520Ethernet = new VerifoneVx520Ethernet();

    private static final class UniqueInstanceHolder {
        private static final Verifone520Ethernet uniqueInstance = new Verifone520Ethernet();
    }

    public static Verifone520Ethernet getInstance() {
        return UniqueInstanceHolder.uniqueInstance;
    }
    @Override
    public void open() {
        verifoneVx520Ethernet.open();
    }

    @Override
    public void send(Transaction transaction) {
        verifoneVx520Ethernet.send(Serializer.serialize(transaction));
    }

    @Override
    public TransactionResponse receive() {
        return (TransactionResponse) Serializer.deserialize(verifoneVx520Ethernet.receive());
    }

    @Override
    public void close() {
        verifoneVx520Ethernet.close();
    }
}

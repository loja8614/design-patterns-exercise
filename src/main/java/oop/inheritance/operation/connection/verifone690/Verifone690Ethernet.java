package oop.inheritance.operation.connection.verifone690;

import oop.inheritance.operation.connection.Communication;
import oop.inheritance.model.Transaction;
import oop.inheritance.model.TransactionResponse;
import oop.inheritance.transaction.Serializer;
import oop.library.vx690.VerifoneVx690Ethernet;

public class Verifone690Ethernet   implements Communication {
    private VerifoneVx690Ethernet verifoneVx690Ethernet = new VerifoneVx690Ethernet();

    private static final class UniqueInstanceHolder {
        private static final Verifone690Ethernet uniqueInstance = new Verifone690Ethernet();
    }

    public static Verifone690Ethernet getInstance() {
        return UniqueInstanceHolder.uniqueInstance;
    }
    @Override
    public void open() {
        verifoneVx690Ethernet.open();
    }

    @Override
    public void send(Transaction transaction) {
        verifoneVx690Ethernet.send(Serializer.serialize(transaction));
    }

    @Override
    public TransactionResponse receive() {
        return (TransactionResponse) Serializer.deserialize(verifoneVx690Ethernet.receive());
    }

    @Override
    public void close() {
        verifoneVx690Ethernet.close();
    }
}

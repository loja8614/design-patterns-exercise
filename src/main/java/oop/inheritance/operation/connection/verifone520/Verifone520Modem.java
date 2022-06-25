package oop.inheritance.operation.connection.verifone520;

import oop.inheritance.operation.connection.Communication;
import oop.inheritance.model.Transaction;
import oop.inheritance.model.TransactionResponse;
import oop.inheritance.transaction.Serializer;
import oop.library.vx520.VerifoneVx520Modem;

public class Verifone520Modem implements Communication {
    private VerifoneVx520Modem verifoneVx520Modem = new VerifoneVx520Modem();

    private static final class UniqueInstanceHolder {
        private static final Verifone520Modem uniqueInstance = new Verifone520Modem();
    }

    public static Verifone520Modem getInstance() {
        return UniqueInstanceHolder.uniqueInstance;
    }

    @Override
    public void open() {
        verifoneVx520Modem.open();
    }

    @Override
    public void send(Transaction transaction) {
        verifoneVx520Modem.send(Serializer.serialize(transaction));
    }

    @Override
    public TransactionResponse receive() {
        return (TransactionResponse) Serializer.deserialize(verifoneVx520Modem.receive());
    }

    @Override
    public void close() {
        verifoneVx520Modem.close();
    }
}

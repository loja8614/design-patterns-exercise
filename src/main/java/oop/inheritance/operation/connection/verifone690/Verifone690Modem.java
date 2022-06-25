package oop.inheritance.operation.connection.verifone690;

import oop.inheritance.operation.connection.Communication;
import oop.inheritance.model.Transaction;
import oop.inheritance.model.TransactionResponse;
import oop.inheritance.transaction.Serializer;
import oop.library.vx690.VerifoneVx690Modem;

public class Verifone690Modem implements Communication {
    private VerifoneVx690Modem verifoneVx690Modem = new VerifoneVx690Modem();

    public Verifone690Modem() {
    }

    private static final class UniqueInstanceHolder {
        private static final Verifone690Modem uniqueInstance = new Verifone690Modem();
    }

    public static Verifone690Modem getInstance() {
        return UniqueInstanceHolder.uniqueInstance;
    }

    @Override
    public void open() {
        verifoneVx690Modem.open();
    }

    @Override
    public void send(Transaction transaction) {
        verifoneVx690Modem.send(Serializer.serialize(transaction));
    }

    @Override
    public TransactionResponse receive() {
        return (TransactionResponse) Serializer.deserialize(verifoneVx690Modem.receive());
    }

    @Override
    public void close() {
        verifoneVx690Modem.close();
    }
}

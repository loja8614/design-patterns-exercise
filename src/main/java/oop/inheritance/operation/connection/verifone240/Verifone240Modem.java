package oop.inheritance.operation.connection.verifone240;

import oop.inheritance.operation.connection.Communication;
import oop.inheritance.model.Transaction;
import oop.inheritance.model.TransactionResponse;
import oop.inheritance.transaction.Serializer;
import oop.library.v240m.VerifoneV240mModem;

public class Verifone240Modem implements Communication {

    private VerifoneV240mModem verifoneV240mModem = new VerifoneV240mModem();

    private static final class UniqueInstanceHolder {
        private static final Verifone240Modem uniqueInstance = new Verifone240Modem();
    }

    public static Verifone240Modem getInstance() {
        return UniqueInstanceHolder.uniqueInstance;
    }

    @Override
    public void open() {
        verifoneV240mModem.open();
    }

    @Override
    public void send(Transaction transaction) {
        verifoneV240mModem.send(Serializer.serialize(transaction));
    }

    @Override
    public TransactionResponse receive() {
        return (TransactionResponse) Serializer.deserialize(verifoneV240mModem.receive());
    }

    @Override
    public void close() {
        verifoneV240mModem.close();
    }
}

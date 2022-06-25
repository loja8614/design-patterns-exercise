package oop.inheritance.operation.connection.verifone240;

import oop.inheritance.operation.connection.Communication;
import oop.inheritance.model.Transaction;
import oop.inheritance.model.TransactionResponse;
import oop.inheritance.transaction.Serializer;
import oop.library.v240m.VerifoneV240mGPS;

public class Verifone240Gps implements Communication {

    private VerifoneV240mGPS verifoneV240mGPS = new VerifoneV240mGPS();

    private static final class UniqueInstanceHolder {
        private static final Verifone240Gps uniqueInstance = new Verifone240Gps();
    }

    public static Verifone240Gps getInstance() {
        return UniqueInstanceHolder.uniqueInstance;
    }

    @Override
    public void open() {
        verifoneV240mGPS.open();
    }

    @Override
    public void send(Transaction transaction) {
        verifoneV240mGPS.send(Serializer.serialize(transaction));
    }

    @Override
    public TransactionResponse receive() {
        return (TransactionResponse) Serializer.deserialize(verifoneV240mGPS.receive());
    }

    @Override
    public void close() {
        verifoneV240mGPS.close();
    }
}

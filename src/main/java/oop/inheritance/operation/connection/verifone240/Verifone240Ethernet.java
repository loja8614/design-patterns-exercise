package oop.inheritance.operation.connection.verifone240;

import oop.inheritance.operation.connection.Communication;
import oop.inheritance.model.Transaction;
import oop.inheritance.model.TransactionResponse;
import oop.inheritance.transaction.Serializer;
import oop.library.v240m.VerifoneV240mEthernet;

public class Verifone240Ethernet implements Communication {

    private VerifoneV240mEthernet verifoneV240mEthernet = new VerifoneV240mEthernet();

    private static final class UniqueInstanceHolder {
        private static final Verifone240Ethernet uniqueInstance = new Verifone240Ethernet();
    }

    public static Verifone240Ethernet getInstance() {
        return UniqueInstanceHolder.uniqueInstance;
    }

    @Override
    public void open() {
        verifoneV240mEthernet.open();
    }

    @Override
    public void send(Transaction transaction) {
        verifoneV240mEthernet.send(Serializer.serialize(transaction));
    }

    @Override
    public TransactionResponse receive() {
        return (TransactionResponse) Serializer.deserialize(verifoneV240mEthernet.receive());
    }

    @Override
    public void close() {
        verifoneV240mEthernet.close();
    }
}

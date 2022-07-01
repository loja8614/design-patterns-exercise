package oop.inheritance.operation.connection.verifone520;

import oop.inheritance.operation.connection.Communication;
import oop.inheritance.model.TransactionDTO;
import oop.inheritance.model.TransactionResponseDTO;
import oop.inheritance.transaction.Serializer;
import oop.library.vx520.VerifoneVx520Ethernet;

public class Verifone520Ethernet implements Communication {
    private VerifoneVx520Ethernet verifoneVx520Ethernet = new VerifoneVx520Ethernet();

    private Verifone520Ethernet() {
    }

    private static Verifone520Ethernet uniqueInstance;

    public static Verifone520Ethernet getInstance() {
        if (uniqueInstance == null) {
            synchronized (Verifone520Ethernet.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Verifone520Ethernet();
                }
            }
        }
        return uniqueInstance;
    }

    @Override
    public void open() {
        verifoneVx520Ethernet.open();
    }

    @Override
    public void send(TransactionDTO transaction) {
        verifoneVx520Ethernet.send(Serializer.serialize(transaction));
    }

    @Override
    public TransactionResponseDTO receive() {
        return (TransactionResponseDTO) Serializer.deserialize(verifoneVx520Ethernet.receive());
    }

    @Override
    public void close() {
        verifoneVx520Ethernet.close();
    }
}

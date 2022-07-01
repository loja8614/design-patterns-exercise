package oop.inheritance.operation.connection.verifone690;

import oop.inheritance.operation.connection.Communication;
import oop.inheritance.model.TransactionDTO;
import oop.inheritance.model.TransactionResponseDTO;
import oop.inheritance.transaction.Serializer;
import oop.library.vx690.VerifoneVx690Ethernet;

public class Verifone690Ethernet implements Communication {
    private VerifoneVx690Ethernet verifoneVx690Ethernet = new VerifoneVx690Ethernet();

    private Verifone690Ethernet() {

    }

    private static Verifone690Ethernet uniqueInstance;

    public static Verifone690Ethernet getInstance() {
        if (uniqueInstance == null) {
            synchronized (Verifone690Ethernet.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Verifone690Ethernet();
                }
            }
        }
        return uniqueInstance;
    }

    @Override
    public void open() {
        verifoneVx690Ethernet.open();
    }

    @Override
    public void send(TransactionDTO transaction) {
        verifoneVx690Ethernet.send(Serializer.serialize(transaction));
    }

    @Override
    public TransactionResponseDTO receive() {
        return (TransactionResponseDTO) Serializer.deserialize(verifoneVx690Ethernet.receive());
    }

    @Override
    public void close() {
        verifoneVx690Ethernet.close();
    }
}

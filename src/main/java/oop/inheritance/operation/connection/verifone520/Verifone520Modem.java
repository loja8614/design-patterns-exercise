package oop.inheritance.operation.connection.verifone520;

import oop.inheritance.operation.connection.Communication;
import oop.inheritance.model.TransactionDTO;
import oop.inheritance.model.TransactionResponseDTO;
import oop.inheritance.transaction.Serializer;
import oop.library.vx520.VerifoneVx520Modem;

public class Verifone520Modem implements Communication {
    private VerifoneVx520Modem verifoneVx520Modem = new VerifoneVx520Modem();

    private Verifone520Modem() {

    }

    private static Verifone520Modem uniqueInstance;

    public static Verifone520Modem getInstance() {
        if (uniqueInstance == null) {
            synchronized (Verifone520Modem.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Verifone520Modem();
                }
            }
        }
        return uniqueInstance;
    }

    @Override
    public void open() {
        verifoneVx520Modem.open();
    }

    @Override
    public void send(TransactionDTO transaction) {
        verifoneVx520Modem.send(Serializer.serialize(transaction));
    }

    @Override
    public TransactionResponseDTO receive() {
        return (TransactionResponseDTO) Serializer.deserialize(verifoneVx520Modem.receive());
    }

    @Override
    public void close() {
        verifoneVx520Modem.close();
    }
}

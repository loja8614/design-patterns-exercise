package oop.inheritance.operation.connection.verifone520;

import oop.inheritance.operation.connection.Communication;
import oop.inheritance.model.TransactionDTO;
import oop.inheritance.model.TransactionResponseDTO;
import oop.inheritance.transaction.Serializer;
import oop.library.vx520.VerifoneVx520GPS;

public class Verifone520Gps implements Communication {
    private VerifoneVx520GPS verifoneVx520GPS = new VerifoneVx520GPS();

    private Verifone520Gps() {

    }

    private static Verifone520Gps uniqueInstance;

    public static Verifone520Gps getInstance() {
        if (uniqueInstance == null) {
            synchronized (Verifone520Gps.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Verifone520Gps();
                }
            }
        }
        return uniqueInstance;
    }

    @Override
    public void open() {
        verifoneVx520GPS.open();
    }

    @Override
    public void send(TransactionDTO transaction) {
        verifoneVx520GPS.send(Serializer.serialize(transaction));
    }

    @Override
    public TransactionResponseDTO receive() {
        return (TransactionResponseDTO) Serializer.deserialize(verifoneVx520GPS.receive());
    }

    @Override
    public void close() {
        verifoneVx520GPS.close();
    }
}

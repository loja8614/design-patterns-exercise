package oop.inheritance.operation.connection.verifone690;

import oop.inheritance.model.mapper.ConverterVerifone;
import oop.inheritance.operation.connection.Communication;
import oop.inheritance.model.TransactionDTO;
import oop.inheritance.model.TransactionResponseDTO;
import oop.library.vx690.VerifoneVx690GPS;

public class Verifone690Gps implements Communication {
    private VerifoneVx690GPS verifoneVx690GPS = new VerifoneVx690GPS();
    private ConverterVerifone modelMapper = new ConverterVerifone();
    private Verifone690Gps() {

    }

    private static Verifone690Gps uniqueInstance;

    public static Verifone690Gps getInstance() {
        if (uniqueInstance == null) {
            synchronized (Verifone690Gps.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Verifone690Gps();
                }
            }
        }
        return uniqueInstance;
    }

    @Override
    public void open() {
        verifoneVx690GPS.open();
    }

    @Override
    public void send(TransactionDTO transaction) {
        verifoneVx690GPS.send(modelMapper.transactionToByte(transaction));
    }

    @Override
    public TransactionResponseDTO receive() {
        return modelMapper.toTransactionResponseDTO(verifoneVx690GPS.receive());
    }

    @Override
    public void close() {
        verifoneVx690GPS.close();
    }
}

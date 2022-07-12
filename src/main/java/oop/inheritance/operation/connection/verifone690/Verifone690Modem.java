package oop.inheritance.operation.connection.verifone690;

import oop.inheritance.model.mapper.ConverterVerifone;
import oop.inheritance.operation.connection.Communication;
import oop.inheritance.model.TransactionDTO;
import oop.inheritance.model.TransactionResponseDTO;
import oop.library.vx690.VerifoneVx690Modem;

public class Verifone690Modem implements Communication {
    private VerifoneVx690Modem verifoneVx690Modem = new VerifoneVx690Modem();
    private ConverterVerifone modelMapper = new ConverterVerifone();
    private Verifone690Modem() {
    }

    private static Verifone690Modem uniqueInstance;

    public static Verifone690Modem getInstance() {
        if (uniqueInstance == null) {
            synchronized (Verifone690Modem.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Verifone690Modem();
                }
            }
        }
        return uniqueInstance;
    }

    @Override
    public void open() {
        verifoneVx690Modem.open();
    }

    @Override
    public void send(TransactionDTO transaction) {
        verifoneVx690Modem.send(modelMapper.transactionToByte(transaction));
    }

    @Override
    public TransactionResponseDTO receive() {
        return modelMapper.toTransactionResponseDTO(verifoneVx690Modem.receive());
    }

    @Override
    public void close() {
        verifoneVx690Modem.close();
    }
}

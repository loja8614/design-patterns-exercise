package oop.inheritance.operation.connection.verifone520;

import oop.inheritance.model.mapper.ConverterVerifone;
import oop.inheritance.operation.connection.Communication;
import oop.inheritance.model.TransactionDTO;
import oop.inheritance.model.TransactionResponseDTO;
import oop.library.vx520.VerifoneVx520Ethernet;

public class Verifone520Ethernet implements Communication {
    private VerifoneVx520Ethernet verifoneVx520Ethernet = new VerifoneVx520Ethernet();
    private ConverterVerifone modelMapper = new ConverterVerifone();

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
        verifoneVx520Ethernet.send(modelMapper.transactionToByte(transaction));
    }

    @Override
    public TransactionResponseDTO receive() {
        return modelMapper.toTransactionResponseDTO(verifoneVx520Ethernet.receive());
    }

    @Override
    public void close() {
        verifoneVx520Ethernet.close();
    }
}

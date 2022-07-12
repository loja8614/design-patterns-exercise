package oop.inheritance.operation.connection.verifone240;

import oop.inheritance.model.mapper.ConverterVerifone;
import oop.inheritance.operation.connection.Communication;
import oop.inheritance.model.TransactionDTO;
import oop.inheritance.model.TransactionResponseDTO;
import oop.library.v240m.*;

public class Verifone240Modem implements Communication {

    private VerifoneV240mModem verifoneV240mModem = new VerifoneV240mModem();
    private ConverterVerifone modelMapper = new ConverterVerifone();

    private Verifone240Modem() {

    }

    private static Verifone240Modem uniqueInstance;

    public static Verifone240Modem getInstance() {
        if (uniqueInstance == null) {
            synchronized (Verifone240Modem.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Verifone240Modem();
                }
            }
        }
        return uniqueInstance;
    }

    @Override
    public void open() {
        verifoneV240mModem.open();
    }

    @Override
    public void send(TransactionDTO transaction) {
        verifoneV240mModem.send(modelMapper.transactionToByte(transaction));
    }

    @Override
    public TransactionResponseDTO receive() {
        return modelMapper.toTransactionResponseDTO(verifoneV240mModem.receive());
    }

    @Override
    public void close() {
        verifoneV240mModem.close();
    }
}

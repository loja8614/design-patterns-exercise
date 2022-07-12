package oop.inheritance.operation.connection.verifone240;

import oop.inheritance.model.mapper.ConverterVerifone;
import oop.inheritance.operation.connection.Communication;
import oop.inheritance.model.TransactionDTO;
import oop.inheritance.model.TransactionResponseDTO;
import oop.library.v240m.VerifoneV240mGPS;

public class Verifone240Gps implements Communication {

    private VerifoneV240mGPS verifoneV240mGPS = new VerifoneV240mGPS();
    private ConverterVerifone modelMapper = new ConverterVerifone();

    private Verifone240Gps() {

    }

    private static Verifone240Gps uniqueInstance;

    public static Verifone240Gps getInstance() {
        if (uniqueInstance == null) {
            synchronized (Verifone240Gps.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Verifone240Gps();
                }
            }
        }
        return uniqueInstance;
    }

    @Override
    public void open() {
        verifoneV240mGPS.open();
    }

    @Override
    public void send(TransactionDTO transaction) {
        verifoneV240mGPS.send(modelMapper.transactionToByte(transaction));
    }

    @Override
    public TransactionResponseDTO receive() {
        return modelMapper.toTransactionResponseDTO(verifoneV240mGPS.receive());
    }

    @Override
    public void close() {
        verifoneV240mGPS.close();
    }
}

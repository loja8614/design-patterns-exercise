package oop.inheritance.operation.connection.verifone240;

import oop.inheritance.model.mapper.ConverterVerifone;
import oop.inheritance.operation.connection.Communication;
import oop.inheritance.model.TransactionDTO;
import oop.inheritance.model.TransactionResponseDTO;
import oop.library.v240m.VerifoneV240mEthernet;

public class Verifone240Ethernet implements Communication {

    private VerifoneV240mEthernet verifoneV240mEthernet = new VerifoneV240mEthernet();
    private ConverterVerifone modelMapper = new ConverterVerifone();

    private Verifone240Ethernet() {

    }

    private static Verifone240Ethernet uniqueInstance;

    public static Verifone240Ethernet getInstance() {
        if (uniqueInstance == null) {
            synchronized (Verifone240Ethernet.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Verifone240Ethernet();
                }
            }
        }
        return uniqueInstance;
    }

    @Override
    public void open() {
        verifoneV240mEthernet.open();
    }

    @Override
    public void send(TransactionDTO transaction) {
        verifoneV240mEthernet.send(modelMapper.transactionToByte(transaction));
    }

    @Override
    public TransactionResponseDTO receive() {
        return modelMapper.toTransactionResponseDTO(verifoneV240mEthernet.receive());
    }

    @Override
    public void close() {
        verifoneV240mEthernet.close();
    }
}

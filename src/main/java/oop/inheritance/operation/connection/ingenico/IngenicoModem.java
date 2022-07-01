package oop.inheritance.operation.connection.ingenico;

import oop.inheritance.operation.connection.Communication;
import oop.inheritance.model.TransactionDTO;
import oop.inheritance.model.TransactionResponseDTO;

public class IngenicoModem implements Communication {
    private IngenicoModem modem = new IngenicoModem();
    private IngenicoModem(){}
    private static IngenicoModem uniqueInstance ;

    public static IngenicoModem getInstance() {
        if (uniqueInstance ==null){
            synchronized (IngenicoModem.class){
                if(uniqueInstance==null){
                    uniqueInstance=new IngenicoModem();
                }
            }
        }
        return uniqueInstance;
    }

    @Override
    public void open() {
        modem.open();
    }

    @Override
    public void send(TransactionDTO transaction) {
        modem.send(transaction);
    }

    @Override
    public TransactionResponseDTO receive() {
        return modem.receive();
    }

    @Override
    public void close() {
        modem.close();
    }
}

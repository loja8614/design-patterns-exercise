package oop.inheritance.operation.connection.ingenico;

import oop.inheritance.operation.connection.Communication;
import oop.inheritance.model.TransactionDTO;
import oop.inheritance.model.TransactionResponseDTO;

public class IngenicoEthernet implements Communication {
    private IngenicoEthernet ethernet = new IngenicoEthernet();
    private IngenicoEthernet(){}
    private static IngenicoEthernet uniqueInstance;

    public static IngenicoEthernet getInstance() {
        if (uniqueInstance ==null){
            synchronized (IngenicoEthernet.class){
                if(uniqueInstance==null){
                    uniqueInstance=new IngenicoEthernet();
                }
            }
        }
        return uniqueInstance;
    }

    @Override
    public void open() {
        ethernet.open();
    }

    @Override
    public void send(TransactionDTO transaction) {
        ethernet.send(transaction);
    }

    @Override
    public TransactionResponseDTO receive() {
        return ethernet.receive();
    }

    @Override
    public void close() {
        ethernet.close();
    }
}

package oop.inheritance.operation.connection.ingenico;

import oop.inheritance.operation.connection.Communication;
import oop.inheritance.model.TransactionDTO;
import oop.inheritance.model.TransactionResponseDTO;
import oop.library.ingenico.services.IngenicoGPS;

public class IngenicoGps implements Communication {
    private IngenicoGPS gps = new IngenicoGPS();

    private IngenicoGps(){}
    private static  IngenicoGps uniqueInstance ;

    public static IngenicoGps getInstance() {
        if (uniqueInstance ==null){
            synchronized (IngenicoGps.class){
                if(uniqueInstance==null){
                    uniqueInstance=new IngenicoGps();
                }
            }
        }
        return uniqueInstance;
    }

    @Override
    public void open() {
        gps.open();
    }

    @Override
    public void send(TransactionDTO transaction) {
        //gps.send(transaction);
    }

    @Override
    public TransactionResponseDTO receive() {
        return null;//(TransactionResponseDTO) gps.receive();
    }

    @Override
    public void close() {
        gps.close();
    }
}
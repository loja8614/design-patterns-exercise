package oop.inheritance.operation.connection.ingenico;

import oop.inheritance.model.mapper.ConverterIngenico;
import oop.inheritance.operation.connection.Communication;
import oop.inheritance.model.TransactionDTO;
import oop.inheritance.model.TransactionResponseDTO;
import oop.library.ingenico.services.IngenicoGPS;

public class IngenicoGps implements Communication {
    private IngenicoGPS gps = new IngenicoGPS();
    private ConverterIngenico transactionMapped = new ConverterIngenico();


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
        gps.send(transactionMapped.convertTransactionDtoToTransaction(transaction));
    }

    @Override
    public TransactionResponseDTO receive() {
        return  new TransactionResponseDTO(gps.receive().isApproved(),gps.receive().getHostReference());
    }

    @Override
    public void close() {
        gps.close();
    }
}
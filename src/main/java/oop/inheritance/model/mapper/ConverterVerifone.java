package oop.inheritance.model.mapper;

import oop.inheritance.data.EntryMode;
import oop.inheritance.model.CardDTO;
import oop.inheritance.model.ExpirationDateDTO;
import oop.inheritance.model.TransactionDTO;
import oop.inheritance.model.TransactionResponseDTO;

import java.io.*;

public class ConverterVerifone {

    public CardDTO toCardDto(){
        return CardDTO.builder().account("4558211532252558").entryMode(EntryMode.INSERTED).expirationDate(ExpirationDateDTO.builder().year(20).month(8).build()).build();
    }

    public byte[] transactionToByte(TransactionDTO transactionDTO){

        ByteArrayOutputStream b = new ByteArrayOutputStream();
        ObjectOutputStream o = null;
        try {
            o = new ObjectOutputStream(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            o.writeObject(transactionDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b.toByteArray();

    }

    public TransactionResponseDTO toTransactionResponseDTO(byte[] bytes) {
        ByteArrayInputStream b = new ByteArrayInputStream(bytes);
        ObjectInputStream o = null;
        try {
            o = new ObjectInputStream(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return (TransactionResponseDTO) o.readObject();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}

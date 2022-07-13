package oop.inheritance.model.mapper;

import oop.inheritance.enums.EntryMode;
import oop.inheritance.model.CardDTO;
import oop.inheritance.model.ExpirationDateDTO;
import oop.inheritance.model.TransactionDTO;
import oop.inheritance.model.TransactionResponseDTO;
import oop.library.ingenico.model.Card;
import oop.library.ingenico.model.ExpirationDate;


import java.io.*;

public class ConverterVerifone {

    public Card toCard(){
        return Card.builder().account("4558211532252558").entryMode(oop.library.ingenico.model.EntryMode.INSERTED).expirationDate(ExpirationDate.builder().year(20).month(8).build()).build();
    }
    public Card toCard(CardDTO card){
        return Card.builder().account("4558211532252558").entryMode(oop.library.ingenico.model.EntryMode.INSERTED).expirationDate(ExpirationDate.builder().year(20).month(8).build()).build();
    }

    public CardDTO toCardDto(){
        return CardDTO.builder().account("4558211532252558").entryMode(EntryMode.INSERTED).expirationDate(ExpirationDateDTO.builder().year(20).month(8).build()).build();
    }

    public CardDTO toCardDto(Card card){
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

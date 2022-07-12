package oop.inheritance.model.mapper;

import oop.inheritance.model.CardDTO;
import oop.inheritance.data.EntryMode;
import oop.inheritance.model.ExpirationDateDTO;
import oop.inheritance.model.TransactionDTO;
import oop.library.ingenico.model.Card;
import oop.library.ingenico.model.ExpirationDate;
import oop.library.ingenico.model.Transaction;


public class ConverterIngenico {


    public CardDTO convertCardtoCardDto(Card card){
        EntryMode entryModeMapped = toEntryModeData(card.getEntryMode());
        ExpirationDateDTO expirationDate = new ExpirationDateDTO(card.getExpirationDate().getYear(),card.getExpirationDate().getMonth());
        return new CardDTO(card.getAccount(),expirationDate,entryModeMapped);
    }

    public Transaction convertTransactionDtoToTransaction(TransactionDTO transactionDTO){

        oop.library.ingenico.model.EntryMode entryModeMapped = toEntryModeIngenico(transactionDTO.getCard().getEntryMode());
        ExpirationDate expirationDate = new ExpirationDate(transactionDTO.getCard().getExpirationDate().getYear(),transactionDTO.getCard().getExpirationDate().getMonth());

        Transaction transactionIngenico = new Transaction();
        transactionIngenico.setCard(oop.library.ingenico.model.Card.builder().account(transactionDTO.getCard().getAccount()).entryMode(entryModeMapped).expirationDate(expirationDate).build());
        transactionIngenico.setAmountInCents(transactionDTO.getAmountInCents());
        transactionIngenico.setLocalDateTime(transactionDTO.getLocalDateTime());

        return transactionIngenico;
    }

    private oop.library.ingenico.model.EntryMode toEntryModeIngenico(EntryMode entryMode){
        oop.library.ingenico.model.EntryMode entryModeMapped;
        if(entryMode.equals(EntryMode.INSERTED)){
            entryModeMapped=oop.library.ingenico.model.EntryMode.INSERTED;
        }else if(entryMode.equals(EntryMode.MANUAL)){
            entryModeMapped=oop.library.ingenico.model.EntryMode.MANUAL;
        }else{
            entryModeMapped=oop.library.ingenico.model.EntryMode.SWIPED;
        }
        return entryModeMapped;
    }

    private EntryMode toEntryModeData(oop.library.ingenico.model.EntryMode entryMode){
        EntryMode entryModeMapped;

        if(entryMode.equals(EntryMode.INSERTED)){
            entryModeMapped=EntryMode.INSERTED;
        }else if(entryMode.equals(EntryMode.MANUAL)){
            entryModeMapped=EntryMode.MANUAL;
        }else{
            entryModeMapped=EntryMode.SWIPED;
        }
        return entryModeMapped;
    }

}

package oop.inheritance.transaction;


import oop.inheritance.model.CardDTO;
import oop.inheritance.model.TransactionDTO;

import java.time.LocalDateTime;

public class TransactionBuilder implements IBuilderTransaction {
    private int amountInCents;
    private CardDTO card;
    private LocalDateTime localDateTime;

    public TransactionBuilder(CardDTO card){
        this.card=card;

    }
    public TransactionBuilder amountInCents(int amountInCents){
        this.amountInCents=amountInCents;
        return this;
    }

    public TransactionBuilder localTime(LocalDateTime localDateTime){
        this.localDateTime=localDateTime;
        return this;
    }

    @Override
    public TransactionDTO build() {
        TransactionDTO transaction = new TransactionDTO();
        transaction.setCard(this.card);
        transaction.setAmountInCents(this.amountInCents);
        transaction.setLocalDateTime(this.localDateTime);
        return transaction;
    }
}

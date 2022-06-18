package oop.inheritance.transaction;

import oop.library.ingenico.model.Card;
import oop.library.ingenico.model.Transaction;

import java.time.LocalDateTime;

public class TransactionBuilder implements IBuilderTransaction {
    private int amountInCents;
    private Card card;
    private LocalDateTime localDateTime;

    public TransactionBuilder(Card card){
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
    public Transaction build() {
        Transaction transaction = new Transaction();
        transaction.setCard(this.card);
        transaction.setAmountInCents(this.amountInCents);
        transaction.setLocalDateTime(this.localDateTime);
        return transaction;
    }
}

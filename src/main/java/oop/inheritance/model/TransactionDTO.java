package oop.inheritance.model;

import oop.library.ingenico.model.Transaction;

import java.time.LocalDateTime;

public class TransactionDTO {
    private int amountInCents;
    private CardDTO card;
    private LocalDateTime localDateTime;

    public TransactionDTO() {
    }

    public int getAmountInCents() {
        return this.amountInCents;
    }

    public void setAmountInCents(int amountInCents) {
        this.amountInCents = amountInCents;
    }

    public CardDTO getCard() {
        return this.card;
    }

    public void setCard(CardDTO card) {
        this.card = card;
    }

    public LocalDateTime getLocalDateTime() {
        return this.localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}

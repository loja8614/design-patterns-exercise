package oop.inheritance.model;

import java.time.LocalDateTime;

public class Transaction {
    private int amountInCents;
    private Card card;
    private LocalDateTime localDateTime;

    public Transaction() {
    }

    public int getAmountInCents() {
        return this.amountInCents;
    }

    public void setAmountInCents(int amountInCents) {
        this.amountInCents = amountInCents;
    }

    public Card getCard() {
        return this.card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public LocalDateTime getLocalDateTime() {
        return this.localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}

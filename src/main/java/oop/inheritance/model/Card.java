package oop.inheritance.model;

import oop.inheritance.data.EntryMode;

public class Card {
    private final String account;
    private final ExpirationDate expirationDate;
    private final EntryMode entryMode;

    public Card(String account, ExpirationDate expirationDate, EntryMode entryMode) {
        this.account = account;
        this.expirationDate = expirationDate;
        this.entryMode = entryMode;
    }

    public String getAccount() {
        return this.account;
    }

    public ExpirationDate getExpirationDate() {
        return this.expirationDate;
    }

    public EntryMode getEntryMode() {
        return this.entryMode;
    }

    public static CardBuilder builder() {
        return new CardBuilder();
    }
}

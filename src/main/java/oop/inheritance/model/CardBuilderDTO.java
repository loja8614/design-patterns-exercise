package oop.inheritance.model;

import oop.inheritance.data.EntryMode;

public class CardBuilderDTO {
    private String account;
    private ExpirationDateDTO expirationDate;
    private EntryMode entryMode;

    CardBuilderDTO() {
    }

    public CardBuilderDTO account(String account) {
        this.account = account;
        return this;
    }

    public CardBuilderDTO expirationDate(ExpirationDateDTO expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public CardBuilderDTO entryMode(EntryMode entryMode) {
        this.entryMode = entryMode;
        return this;
    }

    public CardDTO build() {
        return new CardDTO(this.account, this.expirationDate, this.entryMode);
    }

}

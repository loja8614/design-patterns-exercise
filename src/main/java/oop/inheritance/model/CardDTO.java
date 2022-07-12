package oop.inheritance.model;

import oop.inheritance.enums.EntryMode;

public class CardDTO {
    private final String account;
    private final ExpirationDateDTO expirationDate;
    private final EntryMode entryMode;

    public CardDTO(String account, ExpirationDateDTO expirationDate, EntryMode entryMode) {
        this.account = account;
        this.expirationDate = expirationDate;
        this.entryMode = entryMode;
    }

    public String getAccount() {
        return this.account;
    }

    public ExpirationDateDTO getExpirationDate() {
        return this.expirationDate;
    }

    public EntryMode getEntryMode() {
        return this.entryMode;
    }

    public static CardBuilderDTO builder() {
        return new CardBuilderDTO();
    }

}

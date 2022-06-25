package oop.inheritance.operation.devices.chipReader;

import oop.inheritance.data.EntryMode;
import oop.inheritance.model.Card;
import oop.inheritance.model.ExpirationDate;
import oop.inheritance.operation.ChipReader;
import oop.library.vx520.VerifoneVx520ChipReader;

public class Verifone520ChipReader implements ChipReader {
    private VerifoneVx520ChipReader chipReader = new VerifoneVx520ChipReader();
    private static final class UniqueInstanceHolder{
        private static final Verifone520ChipReader uniqueInstance = new Verifone520ChipReader();
    }
    public static Verifone520ChipReader getInstance(){
        return UniqueInstanceHolder.uniqueInstance;
    }
    @Override
    public Card readCard() {
        chipReader.readCard();
        return Card.builder().account("4558211532252558").entryMode(EntryMode.INSERTED).expirationDate(ExpirationDate.builder().year(20).month(8).build()).build();
    }

}

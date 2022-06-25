package oop.inheritance.operation.devices.chipReader;

import oop.inheritance.data.EntryMode;
import oop.inheritance.model.Card;
import oop.inheritance.model.ExpirationDate;
import oop.inheritance.operation.ChipReader;
import oop.library.vx690.VerifoneVx690ChipReader;

public class Verifone690ChipReader implements ChipReader {
    private VerifoneVx690ChipReader chipReader = new VerifoneVx690ChipReader();
    private static final class UniqueInstanceHolder{
        private static final Verifone690ChipReader uniqueInstance = new Verifone690ChipReader();
    }
    public static Verifone690ChipReader getInstance(){
        return UniqueInstanceHolder.uniqueInstance;
    }
    @Override
    public Card readCard() {
        chipReader.readCard();
        return Card.builder().account("4558211532252558").entryMode(EntryMode.INSERTED).expirationDate(ExpirationDate.builder().year(20).month(8).build()).build();
    }
}

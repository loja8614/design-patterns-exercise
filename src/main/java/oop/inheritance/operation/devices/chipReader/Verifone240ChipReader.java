package oop.inheritance.operation.devices.chipReader;

import oop.inheritance.data.EntryMode;
import oop.inheritance.model.Card;
import oop.inheritance.model.ExpirationDate;
import oop.inheritance.operation.ChipReader;
import oop.inheritance.transaction.Serializer;
import oop.library.v240m.VerifoneV240mChipReader;

public class Verifone240ChipReader implements ChipReader {
    private VerifoneV240mChipReader chipReader = new VerifoneV240mChipReader();

    private static final class UniqueInstanceHolder{
        private static final Verifone240ChipReader uniqueInstance = new Verifone240ChipReader();
    }
    public static Verifone240ChipReader getInstance(){
        return UniqueInstanceHolder.uniqueInstance;
    }

    @Override
    public Card readCard() {
        chipReader.readCard();
        return Card.builder().account("4558211532252558").entryMode(EntryMode.INSERTED).expirationDate(ExpirationDate.builder().year(20).month(8).build()).build();
    }




}

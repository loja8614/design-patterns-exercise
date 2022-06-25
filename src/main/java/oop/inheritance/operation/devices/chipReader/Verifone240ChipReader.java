package oop.inheritance.operation.devices.chipReader;

import oop.inheritance.model.Card;
import oop.inheritance.operation.ChipReader;
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
        //byte[] card = Serializer.serialize(chipReader.readCard());
        return null;//(Card) Serializer.deserialize(card);
    }
}

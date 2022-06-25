package oop.inheritance.operation.devices.chipReader;

import oop.inheritance.model.Card;
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
        //byte[] card = Serializer.serialize(chipReader.readCard());
        return null;//(Card) Serializer.deserialize(card);
    }
}

package oop.inheritance.operation.devices.chipReader;

import oop.inheritance.model.Card;
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
        //byte[] card = Serializer.serialize(chipReader.readCard());
        return null;//(Card) Serializer.deserialize(card);
    }
}

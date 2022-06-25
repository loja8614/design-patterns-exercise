package oop.inheritance.operation.devices.chipReader;

import oop.inheritance.model.Card;
import oop.inheritance.operation.ChipReader;
import oop.inheritance.transaction.Serializer;

public class IngenicoChipReader implements ChipReader {
    private oop.library.ingenico.services.IngenicoChipReader chipReader = new oop.library.ingenico.services.IngenicoChipReader();

    private static final class UniqueInstanceHolder{
        private static final IngenicoChipReader uniqueInstance = new IngenicoChipReader();
    }
    public static IngenicoChipReader getInstance(){
        return UniqueInstanceHolder.uniqueInstance;
    }


    @Override
    public Card readCard() {
        byte[] card = Serializer.serialize(chipReader.readCard());
        return (Card) Serializer.deserialize(card);
    }
}

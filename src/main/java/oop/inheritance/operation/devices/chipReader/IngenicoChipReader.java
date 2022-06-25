package oop.inheritance.operation.devices.chipReader;

import oop.inheritance.model.Card;
import oop.inheritance.model.ExpirationDate;
import oop.inheritance.model.ExpirationDateBuilder;
import oop.inheritance.operation.ChipReader;
import oop.inheritance.transaction.Serializer;
import oop.library.ingenico.model.EntryMode;

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
        oop.library.ingenico.model.Card card = chipReader.readCard();
        EntryMode entryMode= card.getEntryMode();
        oop.inheritance.data.EntryMode entryModeMapped;

        if(entryMode.equals(EntryMode.INSERTED)){
            entryModeMapped=oop.inheritance.data.EntryMode.INSERTED;
        }else if(entryMode.equals(EntryMode.MANUAL)){
            entryModeMapped=oop.inheritance.data.EntryMode.MANUAL;
        }else{
            entryModeMapped=oop.inheritance.data.EntryMode.SWIPED;
        }
        ExpirationDate expirationDate = new ExpirationDate(card.getExpirationDate().getYear(),card.getExpirationDate().getMonth());

        return Card.builder().account(card.getAccount()).entryMode(entryModeMapped).expirationDate(expirationDate).build();
    }
}

package oop.inheritance.operation.devices.chipReader;

import oop.inheritance.model.CardDTO;
import oop.inheritance.model.ExpirationDateDTO;
import oop.inheritance.operation.ChipReader;
import oop.library.ingenico.model.EntryMode;

public class IngenicoChipReader implements ChipReader {
    private oop.library.ingenico.services.IngenicoChipReader chipReader = new oop.library.ingenico.services.IngenicoChipReader();
    private IngenicoChipReader(){

    }
    private static IngenicoChipReader uniqueInstance ;
    public static IngenicoChipReader getInstance(){
        if (uniqueInstance == null) {
            synchronized (IngenicoChipReader.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new IngenicoChipReader();
                }
            }

        }
        return uniqueInstance;
    }


    @Override
    public CardDTO readCard() {
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
        ExpirationDateDTO expirationDate = new ExpirationDateDTO(card.getExpirationDate().getYear(),card.getExpirationDate().getMonth());

        return CardDTO.builder().account(card.getAccount()).entryMode(entryModeMapped).expirationDate(expirationDate).build();
    }
}

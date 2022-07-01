package oop.inheritance.operation.devices.chipReader;

import oop.inheritance.data.EntryMode;
import oop.inheritance.model.CardDTO;
import oop.inheritance.model.ExpirationDateDTO;
import oop.inheritance.operation.ChipReader;
import oop.library.v240m.VerifoneV240mChipReader;

public class Verifone240ChipReader implements ChipReader {
    private VerifoneV240mChipReader chipReader = new VerifoneV240mChipReader();

    private Verifone240ChipReader() {

    }

    private static Verifone240ChipReader uniqueInstance;

    public static Verifone240ChipReader getInstance() {
        if (uniqueInstance == null) {
            synchronized (Verifone240ChipReader.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Verifone240ChipReader();
                }
            }

        }
        return uniqueInstance;
    }

    @Override
    public CardDTO readCard() {
        chipReader.readCard();
        return CardDTO.builder().account("4558211532252558").entryMode(EntryMode.INSERTED).expirationDate(ExpirationDateDTO.builder().year(20).month(8).build()).build();
    }


}

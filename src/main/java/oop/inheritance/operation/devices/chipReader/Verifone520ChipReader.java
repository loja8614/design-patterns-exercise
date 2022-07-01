package oop.inheritance.operation.devices.chipReader;

import oop.inheritance.data.EntryMode;
import oop.inheritance.model.CardDTO;
import oop.inheritance.model.ExpirationDateDTO;
import oop.inheritance.operation.ChipReader;
import oop.library.vx520.VerifoneVx520ChipReader;

public class Verifone520ChipReader implements ChipReader {
    private VerifoneVx520ChipReader chipReader = new VerifoneVx520ChipReader();
    private Verifone520ChipReader(){}
    private static Verifone520ChipReader uniqueInstance;
    public static Verifone520ChipReader getInstance(){
        if (uniqueInstance == null) {
            synchronized (Verifone520ChipReader.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Verifone520ChipReader();
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

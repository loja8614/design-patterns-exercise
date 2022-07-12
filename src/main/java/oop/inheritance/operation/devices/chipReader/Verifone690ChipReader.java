package oop.inheritance.operation.devices.chipReader;

import oop.inheritance.model.CardDTO;
import oop.inheritance.model.mapper.ConverterVerifone;
import oop.inheritance.operation.ChipReader;
import oop.library.vx690.VerifoneVx690ChipReader;

public class Verifone690ChipReader implements ChipReader {
    private VerifoneVx690ChipReader chipReader = new VerifoneVx690ChipReader();
    private ConverterVerifone modelMapper = new ConverterVerifone();
    private static Verifone690ChipReader uniqueInstance;

    public static Verifone690ChipReader getInstance() {
        if (uniqueInstance == null) {
            synchronized (Verifone690ChipReader.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Verifone690ChipReader();
                }
            }

        }
        return uniqueInstance;
    }

    @Override
    public CardDTO readCard() {
        chipReader.readCard();
        return modelMapper.toCardDto();
    }
}

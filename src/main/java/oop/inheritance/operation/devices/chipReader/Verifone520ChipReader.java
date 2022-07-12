package oop.inheritance.operation.devices.chipReader;


import oop.inheritance.model.CardDTO;
import oop.inheritance.model.mapper.ConverterVerifone;
import oop.inheritance.operation.ChipReader;
import oop.library.vx520.VerifoneVx520ChipReader;

public class Verifone520ChipReader implements ChipReader {
    private VerifoneVx520ChipReader chipReader = new VerifoneVx520ChipReader();
    private ConverterVerifone modelMapper = new ConverterVerifone();
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
        return modelMapper.toCardDto();
    }

}

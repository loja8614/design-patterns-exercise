package oop.inheritance.operation.devices.reader;


import oop.inheritance.model.CardDTO;
import oop.inheritance.model.mapper.ConverterVerifone;
import oop.inheritance.operation.CardProvider;
import oop.library.ingenico.model.Card;
import oop.library.vx520.VerifoneVx520CardSwipper;
import oop.library.vx520.VerifoneVx520ChipReader;

import java.util.function.Consumer;

public class Verifone520CardProvider implements CardProvider {

    private Verifone520CardProvider(){}
    private static Verifone520CardProvider uniqueInstance;
    public static Verifone520CardProvider getInstance(){
        if (uniqueInstance == null) {
            synchronized (Verifone520CardProvider.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Verifone520CardProvider();
                }
            }

        }
        return uniqueInstance;
    }
    public void readCard(Consumer<CardDTO> consumer) {

        ConverterVerifone modelMapper = new ConverterVerifone();
        VerifoneVx520ChipReader chipReader = new VerifoneVx520ChipReader();
        VerifoneVx520CardSwipper cardSwipper= new VerifoneVx520CardSwipper();

        CardDTO card ;
        do {
            //card = modelMapper.toCard(cardSwipper.readCard());
            card = modelMapper.toCardDto();
            if (card == null) {
                //card = modelMapper.toCard(chipReader.readCard());
                card = modelMapper.toCardDto();
            }

        } while (card == null);

        consumer.accept(card);
    }

}

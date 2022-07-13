package oop.inheritance.operation.devices.reader;

import oop.inheritance.model.CardDTO;
import oop.inheritance.model.mapper.ConverterVerifone;
import oop.inheritance.operation.CardProvider;
import oop.library.ingenico.model.Card;
import oop.library.vx690.VerifoneVx690CardSwipper;
import oop.library.vx690.VerifoneVx690ChipReader;

import java.util.function.Consumer;

public class Verifone690CardProvider implements CardProvider {
    private static Verifone690CardProvider uniqueInstance;

    public static Verifone690CardProvider getInstance() {
        if (uniqueInstance == null) {
            synchronized (Verifone690CardProvider.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Verifone690CardProvider();
                }
            }

        }
        return uniqueInstance;
    }

    @Override
    public void readCard(Consumer<CardDTO> consumer) {
        ConverterVerifone modelMapper = new ConverterVerifone();
        VerifoneVx690ChipReader chipReader = new VerifoneVx690ChipReader();
        VerifoneVx690CardSwipper cardSwipper = new VerifoneVx690CardSwipper();
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

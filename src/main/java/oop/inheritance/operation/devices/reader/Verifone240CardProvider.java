package oop.inheritance.operation.devices.reader;

import oop.inheritance.model.CardDTO;
import oop.inheritance.model.mapper.ConverterVerifone;
import oop.inheritance.operation.CardProvider;
import oop.library.ingenico.model.Card;
import oop.library.v240m.VerifoneV240mCardSwipper;
import oop.library.v240m.VerifoneV240mChipReader;

import java.util.function.Consumer;

public class Verifone240CardProvider implements CardProvider {
    private Verifone240CardProvider() {

    }

    private static Verifone240CardProvider uniqueInstance;

    public static Verifone240CardProvider getInstance() {
        if (uniqueInstance == null) {
            synchronized (Verifone240CardProvider.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Verifone240CardProvider();
                }
            }

        }
        return uniqueInstance;
    }

    @Override
    public void readCard(Consumer<CardDTO> consumer) {

        ConverterVerifone modelMapper = new ConverterVerifone();
        VerifoneV240mChipReader chipReader = new VerifoneV240mChipReader();
        VerifoneV240mCardSwipper cardSwipper = new VerifoneV240mCardSwipper();

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

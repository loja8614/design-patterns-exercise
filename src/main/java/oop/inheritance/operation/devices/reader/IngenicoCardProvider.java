package oop.inheritance.operation.devices.reader;

import oop.inheritance.model.CardDTO;
import oop.inheritance.model.mapper.ConverterMapper;
import oop.inheritance.operation.CardProvider;
import oop.library.ingenico.model.Card;
import oop.library.ingenico.services.IngenicoCardSwipper;
import oop.library.ingenico.services.IngenicoChipReader;

import java.util.function.Consumer;


public class IngenicoCardProvider implements CardProvider {

    private IngenicoCardProvider(){

    }
    private static IngenicoCardProvider uniqueInstance ;
    public static IngenicoCardProvider getInstance(){
        if (uniqueInstance == null) {
            synchronized (IngenicoCardProvider.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new IngenicoCardProvider();
                }
            }

        }
        return uniqueInstance;
    }

    public void readCard(Consumer<CardDTO> consumer) {

        ConverterMapper cardMapped1= ConverterMapper.getInstance();
        IngenicoCardSwipper cardSwipper = new IngenicoCardSwipper();
        IngenicoChipReader cardReader = new IngenicoChipReader();
        Card card;
        do {

            card = cardSwipper.readCard();

            if (card == null) {
                card = cardReader.readCard();
            }

        } while (card == null);
        consumer.accept((cardMapped1.toCardDTO(card)));
    }
}

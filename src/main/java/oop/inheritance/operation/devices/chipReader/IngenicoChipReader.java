package oop.inheritance.operation.devices.chipReader;

import oop.inheritance.model.CardDTO;
import oop.inheritance.model.mapper.ConverterIngenico;
import oop.inheritance.model.mapper.ConverterMapper;
import oop.inheritance.operation.ChipReader;


public class IngenicoChipReader implements ChipReader {
    private oop.library.ingenico.services.IngenicoChipReader chipReader = new oop.library.ingenico.services.IngenicoChipReader();
    //private ConverterIngenico cardMapped = new ConverterIngenico();

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
        //return cardMapped.convertCardtoCardDto(chipReader.readCard());
        ConverterMapper cardMapped1= ConverterMapper.getInstance();
        return cardMapped1.toCardDTO(chipReader.readCard());
    }
}

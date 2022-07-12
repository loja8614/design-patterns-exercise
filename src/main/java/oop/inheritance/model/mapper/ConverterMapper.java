package oop.inheritance.model.mapper;

import oop.inheritance.model.CardDTO;
import oop.inheritance.model.TransactionDTO;
import oop.library.ingenico.model.Card;
import oop.library.ingenico.model.Transaction;
import org.modelmapper.ModelMapper;

public class ConverterMapper {
    private ModelMapper modelMapper = new ModelMapper();

    private ConverterMapper() {
    }

    private static ConverterMapper uniqueInstance;

    public static ConverterMapper getInstance() {
        if (uniqueInstance == null) {
            synchronized (ConverterMapper.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new ConverterMapper();
                }
            }
        }
        return uniqueInstance;
    }


    public CardDTO toCardDTO(Card card) {
        return modelMapper.map(card, CardDTO.class);
    }

    public Transaction toTransaction(TransactionDTO transactionResponseDTO) {
        return modelMapper.map(transactionResponseDTO, Transaction.class);
    }
}

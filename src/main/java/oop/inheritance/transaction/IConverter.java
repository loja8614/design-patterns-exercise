package oop.inheritance.transaction;

import oop.inheritance.model.CardBuilderDTO;
import oop.inheritance.model.CardDTO;
import oop.library.ingenico.model.Card;
import oop.library.ingenico.model.CardBuilder;

public interface IConverter {
    CardDTO convertCardToCardDto(Card card);
    //CardBuilderDTO convertCardBuilderToCardBuilderDTO(CardBuilder cardBuilder);

}

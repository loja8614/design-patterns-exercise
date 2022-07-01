package oop.inheritance.transaction;

import oop.inheritance.model.CardDTO;


public interface CardProvider {
    CardDTO readCard(CardDTO card);
}

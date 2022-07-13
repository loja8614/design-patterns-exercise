package oop.inheritance.transaction;

import oop.inheritance.model.CardDTO;

@FunctionalInterface
public interface CardProvider {
    CardDTO readCard(CardDTO card);
    default boolean validate(){return false;}
}

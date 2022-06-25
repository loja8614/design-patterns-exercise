package oop.inheritance.transaction;

import oop.inheritance.model.Card;


public interface ICardProvider {
    Card readCard(Card card);
}

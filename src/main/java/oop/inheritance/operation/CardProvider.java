package oop.inheritance.operation;


import oop.inheritance.model.CardDTO;

import java.util.function.Consumer;

public interface CardProvider {
    void readCard(Consumer<CardDTO> consumer);
}

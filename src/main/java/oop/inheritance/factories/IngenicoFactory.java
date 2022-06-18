package oop.inheritance.factories;

import oop.inheritance.implement.Ingenico;

public class IngenicoFactory implements TerminalFactory {
    @Override
    public ITerminal createTerminal() {
        return new Ingenico();
    }
}

package oop.inheritance.factories;

import oop.inheritance.implement.Verifone240;

public class Verifone240Factory implements TerminalFactory {
    @Override
    public ITerminal createTerminal() {
        return new Verifone240();
    }
}

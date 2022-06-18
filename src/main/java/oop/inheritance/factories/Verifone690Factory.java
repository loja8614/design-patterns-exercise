package oop.inheritance.factories;

import oop.inheritance.implement.Verifone690;

public class Verifone690Factory implements TerminalFactory {
    @Override
    public ITerminal createTerminal() {
        return new Verifone690();
    }
}

package oop.inheritance.factories;

import oop.inheritance.implement.Verifone520;

public class Verifone520Factory  implements TerminalFactory  {
    @Override
    public ITerminal createTerminal() {
        return new Verifone520();
    }
}

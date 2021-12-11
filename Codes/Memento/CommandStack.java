package Memento;
import Command.*;
import Toys.*;

public class CommandStack {
    private ToyProduct toyProduct; // for redo create toyProduct
    private Memento memento;
    private Command command; // for display command list

    public CommandStack(ToyProduct toyProduct, Memento memento, Command command) {
        this.toyProduct = toyProduct;
        this.memento = memento;
        this.command = command;
    }

    public ToyProduct getToyProduct() {
        return toyProduct;
    }

    public void setToyProduct(ToyProduct toyProduct) {
        this.toyProduct = toyProduct;
    }

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}

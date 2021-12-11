package Factories;
import Caretaker.Caretaker;
//import Caretaker.Caretaker;
import Toys.ToyProduct;
import Command.*;
import java.util.Vector;


public abstract class CommandFactory {
    Vector<ToyProduct> toyProducts;
    Caretaker caretaker;

    public abstract Command create() throws Exception;

    public void setToyProduct(Vector<ToyProduct> toyProducts) {
        this.toyProducts = toyProducts;
    }

    public void setCaretaker(Caretaker caretaker) {
        this.caretaker = caretaker;
    }
}

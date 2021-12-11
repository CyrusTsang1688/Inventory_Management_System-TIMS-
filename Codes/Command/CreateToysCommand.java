package Command;
import java.util.*;
import Caretaker.Caretaker;
import Toys.ToyProduct;

public abstract class CreateToysCommand implements Command{

    protected ToyProduct toyProduct;
    protected Vector<ToyProduct> toyProducts;
    protected Caretaker caretaker;
    protected int productID;
    protected String name;

    public CreateToysCommand(Vector<ToyProduct> toyProducts, Caretaker caretaker, int productID, String name) {
        this.toyProducts = toyProducts;
        this.caretaker = caretaker;
        this.productID = productID;
        this.name = name;
    }
    @Override
    public String toString() { //Show The detail of Undo List
        return "Create " + toyProduct.getProductID() + " " + toyProduct.getQty() + " " + toyProduct.getName();
    }
    
    @Override
    public abstract void execute();
}

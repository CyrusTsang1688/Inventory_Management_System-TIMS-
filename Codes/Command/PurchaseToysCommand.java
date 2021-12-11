package Command;
import Caretaker.Caretaker;
import Toys.*;
public class PurchaseToysCommand implements Command{
    private Caretaker caretaker;
    private ToyProduct toyProduct;
    private int quantity;
    private double cost;

    public PurchaseToysCommand(Caretaker caretaker, ToyProduct toyProduct, int quantity, double cost) {
        this.caretaker = caretaker;
        this.toyProduct = toyProduct;
        this.quantity = quantity;
        this.cost = cost;
    }

    @Override
    public void execute() {
        caretaker.saveCurrentState(toyProduct, this);
        toyProduct.setCost(toyProduct.getCost() + cost); //count the total
        toyProduct.setQty(toyProduct.getQty() + quantity);
        System.out.println("Purchased " + quantity + " boxes of " + toyProduct.getName() + ". Current quantity is "
                + toyProduct.getQty() + ". Current cost is $" + String.format("%.0f",toyProduct.getCost()) + ". Price is $" + String.format("%.0f",toyProduct.getPrice()) + ".");
    }

    @Override //display in undo redo list
    public String toString() {
        return "Purchased " + quantity + " " + toyProduct.getProductID() + " " + toyProduct.getName() + " " + String.format("%.0f",cost);
    }
}

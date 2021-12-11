package Command;
import Caretaker.Caretaker;
import Toys.*;
public class SellToysCommand implements Command{

    private Caretaker caretaker;
    private ToyProduct toyProduct;
    private int quantity;
    private double price;

    public SellToysCommand(Caretaker caretaker, ToyProduct toyProduct, int quantity, double price) {
        this.caretaker = caretaker;
        this.toyProduct = toyProduct;
        this.quantity = quantity;
        this.price = price;
    }
        @Override
        public void execute() {
            caretaker.saveCurrentState(toyProduct, this);
            toyProduct.setPrice(price); 
            toyProduct.setQty(toyProduct.getQty() - quantity);
            System.out.println("Sold " + quantity + " boxes of " + toyProduct.getName() + ". Current quantity is "
                    + toyProduct.getQty() + ". Selling price is $" + String.format("%.0f",toyProduct.getPrice()) + ".");
        }
    
        @Override
        public String toString() { //Show The Detail to Undo List
            return "sell " + quantity + " " + toyProduct.getProductID() + " " + toyProduct.getName()  + " " + String.format("%.0f",price);
        }
    }

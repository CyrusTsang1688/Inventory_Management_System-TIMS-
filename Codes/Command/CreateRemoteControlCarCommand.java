package Command;
import java.util.*;
import Toys.*;
import Caretaker.Caretaker;
public class CreateRemoteControlCarCommand extends CreateToysCommand{
    
    private double maxSpeed;

    public CreateRemoteControlCarCommand(Vector<ToyProduct> toyProducts, Caretaker caretaker, int productID, String name, double maxSpeed) {
        super(toyProducts, caretaker, productID, name);
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void execute() {
        toyProduct = new RemoteControlCar(productID, name, maxSpeed);
        toyProducts.add(toyProduct);
        caretaker.saveCurrentState(toyProduct, this);
        System.out.println("New toy product record created.");
    }
}

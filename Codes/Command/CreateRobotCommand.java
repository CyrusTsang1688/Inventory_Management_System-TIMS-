package Command;
import java.util.*;
import Toys.*;
import Caretaker.Caretaker;
public class CreateRobotCommand extends CreateToysCommand{

    private double height;

    public CreateRobotCommand(Vector<ToyProduct> toyProducts, Caretaker caretaker, int productID, String name, double height) {
        super(toyProducts, caretaker, productID, name);
        this.height = height;
    }

    @Override
    public void execute() {
        toyProduct = new Robot(productID, name, height);
        toyProducts.add(toyProduct);
        caretaker.saveCurrentState(toyProduct, this);
        System.out.println("New toy product record created");
    }
}
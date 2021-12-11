package Memento;
import Toys.Robot;
// Robot Memento
public class RobotMemento implements Memento{
    private Robot robot;
    private int productID;
    private int qty;
    private String name;
    private double cost;
    private double price;
    private double height;

    public RobotMemento(Robot robot){
        this.robot = robot;
        this.productID = robot.getProductID();
        this.qty = robot.getQty();
        this.name = robot.getName();
        this.cost = robot.getCost();
        this.price = robot.getPrice();
        this.height = robot.getHeight();
    }

    public void restore(){
        robot.setCost(cost);
        robot.setHeight(height);
        robot.setName(name);
        robot.setPrice(price);
        robot.setQty(qty);
    }

    public int getProductID(){
        return productID;
    }
}

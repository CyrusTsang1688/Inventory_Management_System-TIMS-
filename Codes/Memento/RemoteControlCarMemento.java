package Memento;
import Toys.RemoteControlCar;
// RemoteControlCar Memento
public class RemoteControlCarMemento implements Memento{
    private RemoteControlCar remoteControlCar;
    private int productID;
    private int qty;
    private String name;
    private double cost;
    private double price;
    private double maxSpeed;

    public RemoteControlCarMemento(RemoteControlCar remoteControlCar){
    this.remoteControlCar = remoteControlCar;
    this.productID = remoteControlCar.getProductID();
    this.qty = remoteControlCar.getQty();
    this.name = remoteControlCar.getName();
    this.cost = remoteControlCar.getCost();
    this.price = remoteControlCar.getPrice();
    this.maxSpeed = remoteControlCar.getMaxSpeed();
    }
    public void restore(){
        remoteControlCar.setCost(cost);
        remoteControlCar.setMaxSpeed(maxSpeed);
        remoteControlCar.setName(name);
        remoteControlCar.setPrice(price);
        remoteControlCar.setQty(qty);
    }

    public int getProductID(){
        return productID;
    }
}

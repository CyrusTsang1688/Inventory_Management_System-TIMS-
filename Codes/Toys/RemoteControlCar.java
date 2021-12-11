package Toys;

public class RemoteControlCar extends ToyProduct{
    private double maxSpeed;

    public RemoteControlCar(int productID, String name, double maxSpeed){
      super(productID,name);
      this.maxSpeed=maxSpeed;
    }
  
    public double getMaxSpeed(){
      return maxSpeed;
    }
  
    public void setMaxSpeed(double maxSpeed){
      this.maxSpeed= maxSpeed;
  
    }
  
    public String toString(){
      return super.toString() + "MaxSpeed(km/hr): " + String.format("%.0f",maxSpeed) + super.toDetail();
    }
  
}

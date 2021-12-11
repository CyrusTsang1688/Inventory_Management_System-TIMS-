package Toys;

public class Robot extends ToyProduct{
    
  private double height;

  public Robot(int productID, String name, double height){
    super(productID,name);
    this.height=height;
  }

  public double getHeight(){
    return height;
  }

  public void setHeight(double height){
    this.height= height;

  }

  public String toString(){
    return super.toString() + "Height(cm): " + height + super.toDetail();
  }

}

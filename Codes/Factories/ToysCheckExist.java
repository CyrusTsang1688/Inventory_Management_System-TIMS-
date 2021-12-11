package Factories;
import java.util.*;
import Toys.ToyProduct;

public class ToysCheckExist {
    //check is productID exist or not 
    public static ToyProduct CheckExist(Vector<ToyProduct> toyProducts, int productID){
        for (ToyProduct toyProduct : toyProducts) {
            if (toyProduct.getProductID() == productID) {
                return toyProduct;
            }
        }
        return null;
    }
}

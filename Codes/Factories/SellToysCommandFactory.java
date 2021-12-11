package Factories;
import Command.*;
import Toys.*;

import java.io.*;

public class SellToysCommandFactory extends CommandFactory{
    @Override
    public Command create() throws Exception {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        System.out.println("Enter code:");
        int productID = Integer.parseInt(br.readLine());
        System.out.println("Quantity to be sold:");
        int quantity = Integer.parseInt(br.readLine());
        System.out.println("Selling price:");
        double price = Double.parseDouble(br.readLine());

        ToyProduct toyProduct = ToysCheckExist.CheckExist(toyProducts, productID);

        // error checking
        if (toyProduct == null) {
            System.out.println("The product is not exist!");
            return null;
        }
        if (quantity <= 0) {
            System.out.println("Quantity can't be less than zero!");
            return null;
        }
        if (toyProduct.getQty() < quantity) {
            System.out.println("Quantity is not enough!");
            return null;
        }

        return new SellToysCommand(caretaker, toyProduct, quantity, price);
    }
}

package Factories;
import Command.*;
import java.io.*;

public class DisplayItemCommandFactory extends CommandFactory{
    @Override
    public Command create() throws Exception {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        System.out.println("Enter ID (* to display all)");

        String ProductID = br.readLine();
        return new DisplayItemCommand(toyProducts, ProductID);
    }
}

package Factories;
import Command.*;
import java.io.*;
public class CreateRobotCommandFactory extends CreateToysCommandFactory{
    private double height;// if put it in CreateToysCommandFactory it will violated the open closed principle 
    @Override
    public Command create() throws Exception {

        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        System.out.println("Enter id , name and height(cm)");
        String command = br.readLine();

        // remove whitespace
        String[] record = command.split(",");
        for (int i = 0; i < record.length; i++) {
            record[i] = record[i].trim();
        }

        ProductID = Integer.parseInt(record[0]);
        name = record[1];
        height = Double.parseDouble(record[2]);

        // checking is the ID Exist or not
        if (ToysCheckExist.CheckExist(toyProducts, ProductID) != null) {
            System.out.println("Item already exist!");
            return null;
        }

        return new CreateRobotCommand(toyProducts, caretaker, ProductID, name, height);
    }
}

package Factories;
import Command.*;
import java.io.*;
public class CreateRemoteControlCarCommandFactory extends CreateToysCommandFactory{
    private double maxSpeed;// if put it in CreateToysCommandFactory it will violated the open closed principle 

    @Override
    public Command create() throws Exception {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        System.out.println("Enter id , name and maximum speed(km/hr)");
        String command = br.readLine();

        // remove whitespace
        String[] record = command.split(",");
        for (int i = 0; i < record.length; i++) {
            record[i] = record[i].trim();
        }

        ProductID = Integer.parseInt(record[0]);
        name = record[1];
        maxSpeed = Double.parseDouble(record[2]);

        // checking is the ID Exist or not
        if (ToysCheckExist.CheckExist(toyProducts, ProductID) != null) {
            System.out.println("ID must not duplicate!");
            return null;
        }

        return new CreateRemoteControlCarCommand(toyProducts, caretaker, ProductID, name, maxSpeed);
    }
}

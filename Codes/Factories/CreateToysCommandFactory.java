package Factories;
import Command.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CreateToysCommandFactory extends CommandFactory{
    protected int ProductID;
    protected String name;

    @Override
    public Command create() throws Exception {
        HashMap<String, String> FactoryMap = new HashMap<String, String>() {{
            put("ro", "CreateRobotCommandFactory");
            put("rc", "CreateRemoteControlCarCommandFactory");
        }};

        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        System.out.println("Enter toy type (ro=Robot/rc=Remote Control Car):");
        String line = br.readLine();

        // get the factoryName from the HashMap
        String factory_Name = FactoryMap.get(line);

        // error checking
        // if the Command is not in the HashMap
        if (factory_Name == null) {
            System.out.println("Invalid Command");
            return null;
        }

        // then call the corresponding factory
        CreateToysCommandFactory toyCommandFactory = (CreateToysCommandFactory)Class.forName("Factories." + factory_Name).getDeclaredConstructor().newInstance();
        toyCommandFactory.setToyProduct(toyProducts);
        toyCommandFactory.setCaretaker(caretaker);

        return toyCommandFactory.create();
    }
}

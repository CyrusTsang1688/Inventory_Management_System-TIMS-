import Caretaker.Caretaker;
import Command.*;
import Factories.*;
import Toys.*;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        boolean cont = true;        
        Vector<ToyProduct> toyProduct = new Vector<>();
        Caretaker caretaker = new Caretaker();
        caretaker.setToyProduct(toyProduct);
        Command createFactory;
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        HashMap<String, String> factoryMap = new HashMap<String, String>() {{ //use HashMap to 
            put("x", "ExitCommandFactory");
            put("c", "CreateToysCommandFactory");
            put("d", "DisplayItemCommandFactory");
            put("p", "PurchaseToysCommandFactory");
            put("s", "SellToysCommandFactory");
            put("u", "UndoCommandFactory");
            put("r", "RedoCommandFactory");
            put("l", "ListUndoNRedoCommandFactory");

        }};
          while (cont) {
            try {
                System.out.println("Toy Inventory Management System (TIMS)");
                System.out.println("Please enter command: [c|d|p|s|u|r|l|x]");
                System.out.println("c = create toy, d = display toy, p = purchase toy, s = sell toy,");
                System.out.println("u = undo, r = redo, l = list undo/redo, x = exit system");

                String command = br.readLine();
                String factory_Name = factoryMap.get(command);
                
                if(factory_Name !=null){ //if user input is not null
                CommandFactory commandFactory = (CommandFactory) Class.forName("Factories." + factory_Name).getDeclaredConstructor().newInstance();
                commandFactory.setToyProduct(toyProduct);
                commandFactory.setCaretaker(caretaker);
                createFactory = commandFactory.create();
                 if (createFactory != null) {
                    createFactory.execute();
                }
            }else{ //Show Error Message
                System.out.println("***The command was not exist, Please Try Again.***");
            }
        }catch(Exception e) {
            e.printStackTrace();
            }
            System.out.println();
          }
        }    

}

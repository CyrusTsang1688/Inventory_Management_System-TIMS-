package Command;
import java.util.*;
import java.util.regex.*;
import Factories.ToysCheckExist;
import Toys.*;
public class DisplayItemCommand implements Command{
    private Vector<ToyProduct> toyProducts;
    private String ProductID;
    private String fieldUnit;
    private String fieldName;

    public DisplayItemCommand(Vector<ToyProduct> toyProducts, String ProductID) {
        this.toyProducts = toyProducts;
        this.ProductID = ProductID;
    }

    @Override
    public void execute() {
        if (ProductID.equals("*")) {
            System.out.println();
            System.out.println("Toy product information");
            final String tableFormat = "%-10s%-30s%-15s%-15s%-15s%s\n";
            System.out.printf(tableFormat,
                     "ID", "Name", "Quantity", "Other Info", "Cost", "Price");

            if (toyProducts.isEmpty()) {
                System.out.println("No Item");
                return;
            }

            for (ToyProduct toyProduct: toyProducts) {

                // parse the .toString() format
                String[] Value = toyProduct.toString().split("\n");
                String id = getValue(Value[0]);
                String name = getValue(Value[1]);
                String quantity = getValue(Value[2]);
                String otherInfo = getValue(Value[3]);
                String otherInfoFieldName = getFieldUnit(Value[3]);
                String Cost = getValue(Value[4]);
                String Price = getValue(Value[5]);

                System.out.printf(tableFormat, id, name, quantity, String.format("%.0f", Double.parseDouble(otherInfo)) + otherInfoFieldName, "$" + String.format("%.0f", Double.parseDouble(Cost)), "$" + String.format("%.0f",Double.parseDouble(Price)));
            } 
        } else { //when user input ProductID That existing
            try {
                int productID = Integer.parseInt(ProductID);
                ToyProduct toyProduct = ToysCheckExist.CheckExist(toyProducts, productID);

                // error checking
                if (toyProduct == null){
                    System.out.println("The product is not exist!");
                    return;
                }

                System.out.println();
                System.out.println("Toy product information");
                String[] Value = toyProduct.toString().split("\n");
                String otherInfo = getValue(Value[3]);
                String otherInfoFieldName = getFieldName(Value[3]);
                String Cost = getValue(Value[4]);
                String Price = getValue(Value[5]);

                System.out.println(Value[0]);
                System.out.println(Value[1]);
                System.out.println(Value[2]);
                System.out.println(otherInfoFieldName + ": " + String.format("%.0f", Double.parseDouble(otherInfo)));
                System.out.println("Cost($): " + String.format("%.0f", Double.parseDouble(Cost)));
                System.out.println("Price($): " + String.format("%.0f", Double.parseDouble(Price)));
            } catch (NumberFormatException e){
                System.out.println("Invalid ProductID!");
            }
        }
    }

    private String getValue(String Value){
        return Value.split(": ")[1];
    }

    private String getFieldUnit(String Value){
        fieldUnit = Value.split(": ")[0];
        Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(fieldUnit);
        while(m.find()) {
            fieldUnit = m.group(1);
          }
        return fieldUnit;
    }
    private String getFieldName(String Value){
        fieldName = Value.split(": ")[0];
        return fieldName;
    }
}

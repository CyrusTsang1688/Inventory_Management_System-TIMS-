package Caretaker;
import java.util.*;
import Command.*;
import Memento.*;
import Toys.*;

public class Caretaker {
    private Vector<ToyProduct> toyProducts;
    private Stack<CommandStack> undoStack = new Stack<>();
    private Stack<CommandStack> redoStack = new Stack<>();

    public void setToyProduct(Vector<ToyProduct> toyProducts) {
        this.toyProducts = toyProducts;
    }

    // Create the related Memento of ToyProduct
    public Memento getMemento(ToyProduct toyProduct){
        if (toyProduct instanceof Robot) {
            return new RobotMemento((Robot) toyProduct);
        } else if (toyProduct instanceof RemoteControlCar) {
            return new RemoteControlCarMemento((RemoteControlCar) toyProduct);
        }
        return null;
    }

    public void saveCurrentState(ToyProduct toyProduct, Command command) {
        redoStack.clear();

        // save the current state of ToyProduct
        Memento memento = getMemento(toyProduct);
        undoStack.push(new CommandStack(toyProduct, memento, command));
    }

    public void undo() {
        if (undoStack.empty()) {
            System.out.println("No last undo command.");
            return;
        }

        // pop the last undo command from the Stack
        CommandStack commandStackUD = undoStack.pop();

        // check if it is the create command then remove ToyProduct. if not, restore the ToyProduct item.
        if (commandStackUD.getCommand() instanceof CreateToysCommand) {
            toyProducts.remove(commandStackUD.getToyProduct());
        }else {
            // save the current state of the last undo ToyProduct
            Memento memento = getMemento(commandStackUD.getToyProduct());

            commandStackUD.getMemento().restore();

            // for later redo operation,
            // set the Memento to the new Memento which is before the restore
            commandStackUD.setMemento(memento);
        }
        redoStack.push(commandStackUD);
        System.out.println("Undo completed.");
    }

    public void redo() {
        if (redoStack.empty()) {
            System.out.println("No last redo command.");
            return;
        }

        // pop the last undo command from the Stack
        CommandStack commandStackRD = redoStack.pop();

        // check if it is the create command then remove ToyProduct. if not, restore the ToyProduct item.
        if (commandStackRD.getCommand() instanceof CreateToysCommand) {
            toyProducts.add(commandStackRD.getToyProduct());
        }else {
            // save the current state of the last undo ToyProduct
            Memento memento = getMemento(commandStackRD.getToyProduct());

            commandStackRD.getMemento().restore();

            // for later redo operation,
            // set the Memento to the new Memento which is before the restore
            commandStackRD.setMemento(memento);
        }
        undoStack.push(commandStackRD);
        System.out.println("Redo completed.");
    }

    public void displayUndoRedoList() {
        System.out.println("Undo List:");
        if (undoStack.empty()) {
            System.out.println("Empty");
        } else {
            undoStack.forEach(stackItem -> System.out.println(stackItem.getCommand().toString()));
        }

        System.out.println();

        System.out.println("Redo List:");
        if (redoStack.empty()) {
            System.out.println("Empty");
        } else {
            redoStack.forEach(stackItem -> System.out.println(stackItem.getCommand().toString()));
        }
    }
}

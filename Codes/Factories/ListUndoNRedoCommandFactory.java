package Factories;
import Command.*;

public class ListUndoNRedoCommandFactory extends CommandFactory{
    @Override
    public Command create() throws Exception {
        return new ListUndoNRedoCommand(caretaker);
    }
}

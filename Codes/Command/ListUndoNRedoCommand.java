package Command;
import Caretaker.Caretaker;

public class ListUndoNRedoCommand implements Command{
    private Caretaker caretaker;

    public ListUndoNRedoCommand(Caretaker caretaker) {
        this.caretaker = caretaker;
    }

    @Override
    public void execute() {
        caretaker.displayUndoRedoList();
    }
}

import java.util.ArrayList;
import java.util.List;

public class DrawingApplication {
    private List<Shape> shapes = new ArrayList<>();
    private List<Command> undoStack = new ArrayList<>();

    public List<Shape> getShapes() {
        return shapes;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void moveShape(Shape shape, int newX, int newY) {
        Command moveCommand = new MoveCommand(shape, newX, newY);
        moveCommand.execute();
        undoStack.add(moveCommand);
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            Command lastCommand = undoStack.remove(undoStack.size() - 1);
            lastCommand.undo();
        } else {
            System.out.println("Nothing to undo.");
        }
    }
}
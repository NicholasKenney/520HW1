public class MoveCommand implements Command {
    private Shape shape;
    private int oldX, oldY;
    private int newX, newY;

    public MoveCommand(Shape shape, int newX, int newY) {
        this.shape = shape;
        this.newX = newX;
        this.newY = newY;
        this.oldX = shape.getX();
        this.oldY = shape.getY();
    }

    @Override
    public void execute() {
        shape.move(newX, newY);
    }

    @Override
    public void undo() {
        shape.move(oldX, oldY);
    }
}
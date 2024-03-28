public class Circle implements Shape {
    private int x, y;
    private String color, type;

    public Circle(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.type = "circle";
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }

    @Override
    public void move(int x, int y) {
        System.out.println("Moving Circle to (" + x + ", " + y + ")");
        this.x = x;
        this.y = y;
    }

    @Override
    public void changeColor(String color) {
        System.out.println("Changing Circle color to " + color);
        this.color = color;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getType() {
        return type;
    }
}
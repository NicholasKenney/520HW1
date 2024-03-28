public interface Shape {
    void draw();
    void move(int x, int y);
    void changeColor(String color);

    int getX();
    int getY();
    String getColor();
    String getType();
}
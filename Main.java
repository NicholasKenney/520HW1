import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DrawingApplication drawingApp = new DrawingApplication();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("1. Draw a shape");
            System.out.println("2. Move a shape");
            System.out.println("3. Undo last move");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter shape type (circle/square):");
                    String shapeType = scanner.nextLine();
                    System.out.println("Enter x coordinate:");
                    int x = scanner.nextInt();
                    System.out.println("Enter y coordinate:");
                    int y = scanner.nextInt();
                    System.out.println("Enter color:");
                    String color = scanner.next();
                    scanner.nextLine();

                    if (shapeType.equalsIgnoreCase("circle")) {
                        drawingApp.addShape(new Circle(x, y, color));
                    }else if (shapeType.equalsIgnoreCase("square")) {
                        drawingApp.addShape(new Square(x, y, color));
                    }else {
                        System.out.println("Invalid shape type!");
                    }
                    break;
                case 2:
                    if (drawingApp.getShapes().isEmpty()) {
                        System.out.println("No shapes to move!");
                    }else {
                        System.out.println("Choose a shape:");
                        for (int i = 0; i < drawingApp.getShapes().size(); i++) {
                            Shape current = drawingApp.getShapes().get(i);
                            System.out.println(i + ". " + current.getColor() + " " + current.getType() + " at (" + current.getX() + ", " + current.getY() + ")");
                        }
                        int shapeChoice = scanner.nextInt();
                        scanner.nextLine();

                        if (shapeChoice < 0 || shapeChoice >= drawingApp.getShapes().size()) {
                            System.out.println("Not a valid shape!");
                        }
                        System.out.println("Enter x coordinate:");
                        int newX = scanner.nextInt();
                        System.out.println("Enter y coordinate:");
                        int newY = scanner.nextInt();

                        drawingApp.moveShape(drawingApp.getShapes().get(shapeChoice), newX, newY);
                    }
                    break;
                case 3:
                    drawingApp.undo();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

package bridge;

// Implementação concreta 2
public class PaperDrwaingAPI implements DrawingAPI {

    @Override
    public void drawCircle(double x, double y, double radius) {
        System.out.println("Drawing circle on paper at (" + x + ", " + y + ") with radius " + radius);
    }

    @Override
    public void drawSquare(double x, double y, double side) {
        System.out.println("Drawing square on paper at (" + x + ", " + y + ") with side " + side);
    }

}

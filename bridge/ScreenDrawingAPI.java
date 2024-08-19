package bridge;

// Implementação concreta 1
public class ScreenDrawingAPI implements DrawingAPI {

    @Override
    public void drawCircle(double x, double y, double radius) {
        System.out.println("Drawing circle on screen at (" + x + ", " + y + ") with radius " + radius);
    }

    @Override
    public void drawSquare(double x, double y, double side) {
        System.out.println("Drawing square on screen at (" + x + ", " + y + ") with side " + side);
    }

}

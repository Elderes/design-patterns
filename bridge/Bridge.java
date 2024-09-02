package bridge;

// Implementador 
public interface Bridge {
    void drawCircle(double x, double y, double radius);
    void drawSquare(double x, double y, double side);
}

// Implementação concreta 2
class PaperDrwaingAPI implements Bridge {

    @Override
    public void drawCircle(double x, double y, double radius) {
        System.out.println("Drawing circle on paper at (" + x + ", " + y + ") with radius " + radius);
    }

    @Override
    public void drawSquare(double x, double y, double side) {
        System.out.println("Drawing square on paper at (" + x + ", " + y + ") with side " + side);
    }

}

// Implementação concreta 1
class ScreenDrawingAPI implements Bridge {

    @Override
    public void drawCircle(double x, double y, double radius) {
        System.out.println("Drawing circle on screen at (" + x + ", " + y + ") with radius " + radius);
    }

    @Override
    public void drawSquare(double x, double y, double side) {
        System.out.println("Drawing square on screen at (" + x + ", " + y + ") with side " + side);
    }

}

abstract class Shape {
    protected Bridge drawingAPI;

    protected Shape(Bridge drawingAPI) {
        this.drawingAPI = drawingAPI;
    }

    public abstract void draw();
}
public class WindowsApp {
    public static void main(String[] args) {
        var w1 = new Window("Window 1");

        w1.addRectangle(new Rectangle("Rectangle 1"));
        w1.addCircle(new Circle("Circle 1"));
        w1.addTriangle(new Triangle("Trinagle 1"));

        w1.bringToFront();
    }
}

public class Circle {
    private String name;
    private Point p;
    private double radius;

    public Circle(String name, Point p, double radius) {
        this.name = name;
        this.p = p;
        this.radius = radius;
        this.radius = radius;
    }

    public Circle(String name) {
        this(name, new Point(5, 5), 1);
    }

    public void draw() {
        System.out.println("Drawing " + name);
    }
}

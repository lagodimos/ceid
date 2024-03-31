public class Triangle {
    private String name;
    private Point p1, p2, p3;

    public Triangle(String name, Point p1, Point p2, Point p3) {
        this.name = name;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Triangle(String name) {
        this(name, new Point(5, 5), new Point(30, 30), new Point(10, 10));
    }

    public void draw() {
        System.out.println("Drawing " + name);
    }
}

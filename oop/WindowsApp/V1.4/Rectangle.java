public class Rectangle {
    private String name;
    private Point p1, p2;

    public Rectangle(String name, Point p1, Point p2) {
        this.name = name;
        this.p1 = p1;
        this.p2 = p2;
    }

    public Rectangle(String name) {
        this(name, new Point(5, 5), new Point(20, 30));
    }

    public void draw() {
        System.out.println("Drawing " + name);
    }
}

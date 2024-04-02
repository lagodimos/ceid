import java.util.Vector;

public class Window {
    private String title;
    private Point p1, p2;

    private Vector<Shape> shapes;

    public Window(String title, Point p1, Point p2) {
        this.title = title;
        this.p1 = p1;
        this.p2 = p2;

        shapes = new Vector<>();
    }

    public Window(String title) {
        this(title, new Point(5, 5), new Point(105 ,105));
    }

    public void add(Shape shape) {
        shapes.add(shape);
    }

    public void draw() {
        System.out.println("Drawing " + title + " to the screen.");
    }

    public void bringToFront() {
        draw();

        for (int i = 0; i < shapes.size(); i++) {
            shapes.get(i).draw();
        }
    }
}

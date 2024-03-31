import java.util.Vector;

public class Window {
    private String title;
    private Point p1, p2;

    private Vector<Rectangle> rectangles;
    private Vector<Circle> circles;
    private Vector<Triangle> triangles;

    public Window(String title, Point p1, Point p2) {
        this.title = title;
        this.p1 = p1;
        this.p2 = p2;

        rectangles = new Vector<>();
        circles = new Vector<>();
        triangles = new Vector<>();
    }

    public Window(String title) {
        this(title, new Point(5, 5), new Point(105 ,105));
    }

    public void addRectangle(Rectangle rectangle) {
        rectangles.add(rectangle);
    }

    public void addCircle(Circle circle) {
        circles.add(circle);
    }

    public void addTriangle(Triangle triangle) {
        triangles.add(triangle);
    }

    public void draw() {
        System.out.println("Drawing " + title + " to the screen.");
    }

    public void bringToFront() {
        draw();

        for (int i = 0; i < rectangles.size(); i++) {
            rectangles.get(i).draw();
        }

        for (int i = 0; i < circles.size(); i++) {
            circles.get(i).draw();
        }

        for (int i = 0; i < triangles.size(); i++) {
            triangles.get(i).draw();
        }
    }
}

public class Window {
    private String title;
    private Point p1, p2;

    private Rectangle[] rectangles;
    private Circle[] circles;
    private Triangle[] triangles;

    private int rectangleIndex, circleIndex, triangleIndex;

    public Window(String title, Point p1, Point p2) {
        this.title = title;
        this.p1 = p1;
        this.p2 = p2;

        rectangles = new Rectangle[100];
        circles = new Circle[100];
        triangles = new Triangle[100];
    }

    public Window(String title) {
        this(title, new Point(5, 5), new Point(105 ,105));
    }

    public void addRectangle(Rectangle rectangle) {
        rectangles[rectangleIndex++] = rectangle;
    }

    public void addCircle(Circle circle) {
        circles[circleIndex++] = circle;
    }

    public void addTriangle(Triangle triangle) {
        triangles[triangleIndex++] = triangle;
    }

    public void draw() {
        System.out.println("Drawing " + title + " to the screen.");
    }

    public void bringToFront() {
        draw();

        for (int i = 0; i < rectangleIndex; i++) {
            rectangles[i].draw();
        }

        for (int i = 0; i < circleIndex; i++) {
            circles[i].draw();
        }

        for (int i = 0; i < triangleIndex; i++) {
            triangles[i].draw();
        }
    }
}

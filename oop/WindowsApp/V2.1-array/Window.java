public class Window {
    private String title;
    private Point p1, p2;

    private Shape[] shapes;
    private int shapeIndex;

    public Window(String title, Point p1, Point p2) {
        this.title = title;
        this.p1 = p1;
        this.p2 = p2;

        shapes = new Shape[100];
    }

    public Window(String title) {
        this(title, new Point(5, 5), new Point(105 ,105));
    }

    public void add(Shape shape) {
        shapes[shapeIndex++] = shape;
    }

    public void draw() {
        System.out.println("Drawing " + title + " to the screen.");
    }

    public void bringToFront() {
        draw();

        for (int i = 0; i < shapeIndex; i++) {
            shapes[i].draw();
        }
    }
}

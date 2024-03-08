public class Circle {
    private double x, y, rad;

    public Circle(double x, double y, double rad) {
        this.x = x;
        this.y = y;
        this.rad = rad;
    }

    public void setRadius(double rad) {
        this.rad = rad;
    }

    public double getRadius() {
        return this.rad;
    }

    public boolean hasRadius(double rad) {
        return (rad == this.rad) ? true : false;
    }

    public double circumference() {
        return 2*Math.PI*this.rad;
    }

    public double area() {
        return Math.PI*this.rad*this.rad;
    }

    public String toString() {
        String info = "Center: (" + this.x + ", " + this.y + ")\n" +
                      "Area: " + this.area() + "\n" +
                      "Circumference: " + this.circumference() + "\n";

        return info;
    }
}

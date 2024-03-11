public class Square {
    private Point lowerLeftPoint;
    private Point upperRightPoint;

    public Square(Point lowerLeftPoint, Point upperRightPoint) {
        this.lowerLeftPoint = lowerLeftPoint;
        this.upperRightPoint = upperRightPoint;
    }

    public int area() {
        return ( (upperRightPoint.getX() - lowerLeftPoint.getX()) *
                 (upperRightPoint.getY() - lowerLeftPoint.getY()) );
    }
}

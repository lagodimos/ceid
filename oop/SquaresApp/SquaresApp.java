import java.util.Stack;

public class SquaresApp {
    public static void main(String[] args) {
        int numOfSquares = 10;

        Square square = null;
        Integer prevArea = null;

        Stack<Square> squaresStack = new Stack<>();

        for (int i = 1; i < numOfSquares + 1; i++) {
            var lowerLeftPoint = new Point(0, 0);
            var upperRightPoint = new Point(i, i);

            squaresStack.push(new Square(lowerLeftPoint, upperRightPoint));
        }

        System.out.println("Square areas:");

        for (int i = 0; i < numOfSquares; i++) {
            square = squaresStack.pop();

            System.out.println("Square area: " + square.area() +
                              ((prevArea == null) ? "":
                               "\t\tPrevious area - Current area: " + (prevArea - square.area())));

            if (i < numOfSquares - 1) {
                prevArea = square.area();
            }
        }

        System.out.println("Requested square area: " + (prevArea - square.area()));
        System.out.println("Requested square side: " + Math.sqrt(prevArea - square.area()));
    }
}

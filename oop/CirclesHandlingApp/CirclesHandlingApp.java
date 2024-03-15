public class CirclesHandlingApp {

    public static void main(String args[]) {
        Circle bigCircle;
        Circle smallCircle;

        var c1 = new Circle(2, 3, 4);
        var c2 = new Circle(2, 3, 2);
        var c3 = new Circle(1, 2, 9);
        var c4 = new Circle(2, 3, 5);
        var c5 = new Circle(2, 3, 7);

        Circle[] circles = {c1, c2, c3, c4, c5};

        System.out.println("---- Circles list (" + Circle.instanceCount + " circles) ----\n");
        for (int i = 0; i < Circle.instanceCount; i++) {
            System.out.println(circles[i]);
        }

        for (int i = 0; i < Circle.instanceCount - 1; i++) {
            for (int j = 0; j < Circle.instanceCount - i - 1; j++) {
                bigCircle = Circle.bigger(circles[j], circles[j+1]);
                smallCircle = Circle.smaller(circles[j], circles[j+1]);

                circles[j] = smallCircle;
                circles[j+1] = bigCircle;
            }
        }

        System.out.println("---- Circle list sorted (" + Circle.instanceCount + " circles) ----\n");
        for (int i = 0; i < Circle.instanceCount; i++) {
            System.out.println(circles[i]);
        }
    }
}

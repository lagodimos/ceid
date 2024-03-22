public class ObjectState {
    private static Object1 obj1;
    private static Object2 obj2;

    public static void main(String[] args) {
        obj1 = new Object1(false);
        obj2 = new Object2(obj1);

        obj2.press();

        System.out.println("ObjectState completed!");
    }
}
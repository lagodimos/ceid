import java.util.Stack;

public class Add2Numbers {
    public static void main(String args[]) {
        Stack<Double> dStack = new Stack<>();

        Double doubleOne = 3.1415d;
        Double doubleTwo = 6.2820d;

        dStack.push(doubleOne);
        dStack.push(doubleTwo);

        dStack.push( dStack.pop() + dStack.pop() );

        System.out.println( dStack.pop() );
    }
}

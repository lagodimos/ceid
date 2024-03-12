import java.util.Scanner;

public class Echo {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String input;

        while ( ! (input = scanner.nextLine()).equals("bye") ) {
            System.out.println(input);
        }

        scanner.close();
        System.out.println("bye");
    }
}

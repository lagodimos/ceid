public class CompareDoubles {
    public static void main(String args[]) {

        Double doubleOne = 3.1415d;
        Double doubleTwo = 6.2820d;

        System.out.println(Double.compare(doubleOne, doubleTwo));

        System.out.println(doubleOne.compareTo(doubleTwo));
    }
}

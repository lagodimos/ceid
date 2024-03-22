public class Object2 {
    Object1 object;

    Object2(Object1 object) {
        this.object = object;
    }

    public void press() {
        System.out.println(object);

        object.setState(true);
        System.out.println(object);

        object.setState(false);

        System.out.println("Press completed!");
    }
}

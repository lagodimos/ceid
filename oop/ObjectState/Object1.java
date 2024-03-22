public class Object1 {
    private boolean state;

    Object1(boolean state) {
        this.state = state;
    }

    Object1() {
        this(false);
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String toString() {
        return "Oject1 state: " + ((state) ? "ON" : "OFF");
    }
}

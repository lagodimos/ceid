public class Led {
    private boolean state;

    Led(boolean state) {
        this.state = state;
    }

    Led() {
        this(false);
    }

    public void on() {
        this.state = true;
    }

    public void off() {
        this.state = false;
    }

    public boolean isOn() {
        return this.state;
    }

    public String toString() {
        return "LED state: " + ((state) ? "ON" : "OFF");
    }
}

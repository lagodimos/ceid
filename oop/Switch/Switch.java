public class Switch {
    private static Led led;

    public static void main(String[] args) {
        led = new Led();

        System.out.println("Created an LED!");

        System.out.println("Turning the LED on...");
        led.on();
        System.out.println("LED is " + (led.isOn() ? "ON" : "OFF"));

        System.out.println("Turning the LED off...");
        led.off();
        System.out.println("LED is " + (led.isOn() ? "ON" : "OFF"));

        System.out.println("LED is working!");
    }
}

public class Robot {

    private String name;
    private boolean working;

    public Robot(String name) {
        this.name = name;
        this.working = false;
    }

    public String getName() {
        return name;
    }

    public boolean isWorking() {
        return working;
    }

    public void turnOn() {
        working = true;
    }
}

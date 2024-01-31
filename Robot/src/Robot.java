

public class Robot {

    private String name;
    private boolean working;

    public Robot(String name) {
        setName(name);
        this.working = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException();
        }

        this.name = name;
    }

    public boolean isWorking() {
        return working;
    }

    public void turnOn() {
        working = true;
    }

    public String getWorkingMessage() {
        if (!isWorking()) {
            throw new IllegalStateException();
        }

        return "I am in working mode!";
    }
}

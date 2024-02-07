

public class Robot {

    private String name;
    private boolean working;
    private int age;

    public Robot(String name, int age) {
        setAge(age);
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

    private void setAge(int age) {
        if (age > 30) {
            throw new IllegalArgumentException();
        }
        this.age = age;
    }

    public boolean isWorking() {
        return working;
    }

    public void turnOn() {
        working = true;
    }

    public void turnOff() {
        working = false;
    }

    public String getWorkingMessage() {
        if (!isWorking()) {
            throw new IllegalStateException();
        }

        return "I am in working mode!";
    }

    public String checkAge() {
        return (age <= 20) ? "Age Ok" : "Too old";
    }

    public double checkCost() {
        if (age <= 5) {
            return 10000.00;
        } else if (age <= 10) {
            return 7500.00;
        } else {
            return 5000.00;
        }
    }
}

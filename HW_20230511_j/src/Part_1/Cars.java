package Part_1;

public abstract class Cars {

    public String name;

    public int yearsOfIssue;

    public int maxSpeed;

    public Cars(String name, int yearsOfIssue, int maxSpeed) {
        this.name = name;
        this.yearsOfIssue = yearsOfIssue;
        this.maxSpeed = maxSpeed;
    }

    public abstract void sportCar();

    public abstract void oldOrNewCar();

    @Override
    public String toString() {
        return "Cars: " + name + ", yearsOfIssue: " + yearsOfIssue + ", maxSpeed: " + maxSpeed;
    }
}

package Part_1;

public class Motorbikes {

    public String name;

    public int yearsOfIssue;

    public int maxSpeed;

    public Motorbikes(String name, int yearsOfIssue, int maxSpeed) {
        this.name = name;
        this.yearsOfIssue = yearsOfIssue;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Motorbike: " + name + ", yearsOfIssue: " + yearsOfIssue + ", maxSpeed: " + maxSpeed;
    }
}

package Part_1;

public class BMW extends Cars{


    public BMW(String name, int yearsOfIssue, int maxSpeed) {
        super(name, yearsOfIssue, maxSpeed);
    }

    @Override
    public void sportCar() {
        if (maxSpeed > 250){
            System.out.println(name + " is a sport car");
        } else {
            System.out.println(name + " is not a sport car");
        }
    }

    @Override
    public void oldOrNewCar() {
        if (yearsOfIssue < 2010){
            System.out.println(name + " is a old model of BMW");
        } else {
            System.out.println(name + " is a new model of BMW");
        }
    }
}

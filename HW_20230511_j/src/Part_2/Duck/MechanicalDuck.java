package Part_2.Duck;

public class MechanicalDuck extends Duck{

    public MechanicalDuck(){
        flyBehavior = new FlyWithPropeller();
        quackBehavior = new Squeek();
    }
    @Override
    public void display() {
        System.out.println("With propeller fly is the best!");
    }
}

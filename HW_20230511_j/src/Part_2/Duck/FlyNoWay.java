package Part_2.Duck;

public class FlyNoWay implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("Don't fly");
    }
}

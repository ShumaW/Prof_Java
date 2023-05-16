package Part_2.Duck;

public class QryackDuck extends Duck{


    public QryackDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Qryack();
    }

    @Override
    public void display() {

    }
}

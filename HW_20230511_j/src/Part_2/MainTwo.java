package Part_2;

import Part_2.Duck.MechanicalDuck;
import Part_2.TelRan.TelRan;

public class MainTwo {
    /**
     * 1) Из первой лекции преобразовать класс Tel-Ran в синглтон(синглетный класс)
     * 2) К программе для управления утками(вторая практика) добавить полеты с
     * пропеллером и утку издающую звук squeek
     */

    public static void main(String[] args) {

        System.out.println("-".repeat(50));
        TelRan telRan1 = TelRan.getInstance();
        TelRan telRan2 = TelRan.getInstance();
        System.out.println(telRan1.equals(telRan2));
        System.out.println("-".repeat(50));
        MechanicalDuck mechanicalDuck = new MechanicalDuck();
        mechanicalDuck.performFly();
        mechanicalDuck.performQuack();
        mechanicalDuck.display();
    }
}

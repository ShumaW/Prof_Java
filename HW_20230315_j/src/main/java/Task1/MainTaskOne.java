package Task1;

import java.util.Arrays;
import java.util.concurrent.Exchanger;

public class MainTaskOne {
    /**
     * Создать модель поведения с применением Exchanger:
     * <p>
     * необходимо доставить посылки двумя грузовиками
     * грузовик 1 везет: посылка A -> C и посылка A -> D
     * грузовик 2 везет: посылка B -> C и посылка B -> D
     * A  _ _ _ _             _ _ _ _ B
     * \          /
     * - - E - -
     * _ _ _ _ /          \ _ _ _ _
     * C                              D
     * <p>
     * <p>
     * E - точка обмена
     * каждый грузовик может отвезти обе посылки, но это не оптимально
     * поэтому необходимо создать пункт E для обмена конечными посылками, так чтобы
     * итоговые конечные точки были одинаковые, то есть
     * грузовик 1: посылка A -> C и A -> D, после обмена: A -> D и B -> D
     * грузовик 2: посылка B -> C и B -> D, после обмена: B -> C и A -> C
     */
    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger<>();
        Good[] goods1 = {new Good("Appel","A"), new Good("Orange","B")};
        Good[] goods2 = {new Good("Bread", "B"), new Good("Beef", "A")};

        try {
            new Truck("Track1",goods1,exchanger);
            Thread.sleep(3000);
            new Truck("Track2",goods2,exchanger);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}




//    private void goodExchanger(Good[] goods1, Good[] goods2) {
//        for (int i = 0; i < goods1.length; i++) {
//            for (int j = 0; j < goods2.length; j++) {
//                if (!(goods1[i].getWay().equals(goods2[j].getWay()))) {
//                    goods1[i].setWay(goods2[j].getWay());
//                }
//            }
//        }
//    }

package task1;

import java.util.Arrays;
import java.util.concurrent.Exchanger;


    class Truck extends Thread{
        String name;
        Good[] goods;
        Exchanger<Good> exchanger;
        String truckWay;

        public Truck(String name, Good[] goods, Exchanger exchanger, String way) {
            this.name = name;
            this.goods = goods;
            this.exchanger = exchanger;
            this.truckWay = way;
            this.start();
        }



        @Override
        public void run() {
            try {
                System.out.println(name + " has left its destination.");
                Thread.sleep(2000);
                for (int i = 0; i < goods.length; i++) {
                    if (goods[i].getWay().equals(truckWay)) {
                        goods[i] = exchanger.exchange(goods[i]);
                    }
                }
                System.out.println("Goods was exchanged!");
                Thread.sleep(2000);
                System.out.println(name + " arrived at destination with: " + Arrays.toString(goods));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}

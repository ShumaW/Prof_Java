package Task1;

import java.util.Arrays;
import java.util.concurrent.Exchanger;


    class Truck extends Thread{
        String name;
        Good[] goods;
        Exchanger exchanger;

        public Truck(String name, Good[] goods, Exchanger exchanger) {
            this.name = name;
            this.goods = goods;
            this.exchanger = exchanger;
            this.start();
        }



        @Override
        public void run() {
            try {
                System.out.println(name + " has left its destination.");
                Thread.sleep(2000);
                goods[1] = (Good) exchanger.exchange(goods[1]);
                System.out.println("Goods was exchanged!");
                Thread.sleep(2000);
                System.out.println(name + " arrived at destination with: " + Arrays.toString(goods));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}

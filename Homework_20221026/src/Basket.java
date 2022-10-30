import java.util.Arrays;

public class Basket {
    private Goods[] goodsArray;
    private int size;
    private int capacity;

    public Basket(int capacity) {
        this.capacity = capacity;
        goodsArray = new Goods[capacity];
        size = 0;
    }

    public boolean add(Goods goods) {
        if (size >= goodsArray.length) {
            enlarge();
        }
        goodsArray[size] = goods;
        size++;
        return true;
    }


    private void enlarge() {
        Goods[] arr = new Goods[goodsArray.length * 2];
        for (int i = 0; i < goodsArray.length; i++) {
            arr[i] = goodsArray[i];
        }
        goodsArray = arr;
    }

    public String toString() {
        System.out.println("Your goods are:");
        String res = "";
        for (int i = 0; i < goodsArray.length && i < size; i++) {
            int counter = 1;
            res += goodsArray[i] + System.lineSeparator();
        }
        res += "---------------" + System.lineSeparator() + "Total: " + size + " goods";
        return res;
    }

    public Goods get(int index) {
        if (index < size) {
            return goodsArray[index];
        } else {
            return null;
        }
    }


    public double getTotalPrice(Goods[] goodsArray) {
        double sum = 0;
        for (int i = 0; i < goodsArray.length; i++) {
            sum += goodsArray[i].price;
        }
        return sum;
    }


}

public class Basket {
    private Goods[] goodsArray;
    private int size;
    private int capacity;
    private double price;

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

    /*
    public String toString() {
        System.out.println("Your goods are:");
        String res = "";
        for (int i = 0; i < goodsArray.length && i < size; i++) {
            res += goodsArray[i] + System.lineSeparator();
        }
        res += "---------------" + System.lineSeparator() + "Total: " + size + " goods" + System.lineSeparator() + "Total price : " + getTotalPrice(goodsArray) + "$";
        return res;

    }
    */

    // Метод StringBuilder и оператор .append
    public String toString() {
        System.out.println("Your goods are:");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < goodsArray.length && i < size; i++) {
            res.append(goodsArray[i])
                    .append(System.lineSeparator());
        }
        return res.append("---------------")
                .append(System.lineSeparator())
                .append("Total: " + size + " goods")
                .append(System.lineSeparator())
                .append("Total price : " + getTotalPrice(goodsArray) + "$")
                .toString();

    }



    public Goods get(int index) {
        if (index < size) {
            return goodsArray[index];
        } else {
            return null;
        }
    }


    public double getTotalPrice(Goods[] arr) {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i].price;
        }
        return sum;
    }


}
public class Clothes extends Goods {
    public Clothes(String name, double price) {
        super(name, price);
    }

    public void getGoods() {
        System.out.println("The cost of " + name + " is " + price + "$");
    }

    public String toString() {
        return name + " " + price + "$";
    }

    public double getPriceOfProdukt(){
        super.price = price;
        return price;
    }


}
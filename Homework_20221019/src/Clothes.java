public class Clothes extends Goods{
    public Clothes(String name, double price) {
        super(name, price);
    }

    public void getGoods(){
        System.out.println("The cost of " + name + " is " + price + "$");
    }
}

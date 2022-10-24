public class Produkts extends Goods{
    private int percentOfUrgency;

    public Produkts(String name, double price, int percentOfUrgency) {
        super(name, price);
        this.percentOfUrgency = percentOfUrgency;
    }

    private double priceOfProdukt(){
        return price + (price * (percentOfUrgency / 100));
    }


    public void getGoods (){
        System.out.println("The cost of " + name + " is " + priceOfProdukt() + "$ , with " + percentOfUrgency + "% for urgency");
    }
}

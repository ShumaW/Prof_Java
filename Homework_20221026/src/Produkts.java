public class Produkts extends Goods{
    private int percentOfUrgency;

    public Produkts(String name, double price, int percentOfUrgency) {
        super(name, price);
        this.percentOfUrgency = percentOfUrgency;
    }

    public double priceOfProdukt(){
        return price + (price * (percentOfUrgency / 100));
    }


    public void getGoods (){
        System.out.println("The cost of " + name + " is " + priceOfProdukt() + "$ , including " + percentOfUrgency + "% for urgency");
    }

    public String toString(){

        return name + " " + priceOfProdukt() + "$ , including " + percentOfUrgency + "% for urgency";
    }
}

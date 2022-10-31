public class Produkts extends Goods{
    private int percentOfUrgency;

    public Produkts(String name, double price, int percentOfUrgency) {
        super(name, price);
        this.percentOfUrgency = percentOfUrgency;
    }

    public double getPriceOfProdukt(){
        super.price = price + (price * percentOfUrgency / 100);
        return price;
    }


    public void getGoods (){
        System.out.println("The cost of " + name + " is " + getPriceOfProdukt() + "$ , including " + percentOfUrgency + "% for urgency");
    }

    public String toString(){

        return name + " " + getPriceOfProdukt() + "$ , including " + percentOfUrgency + "% for urgency";
    }
}
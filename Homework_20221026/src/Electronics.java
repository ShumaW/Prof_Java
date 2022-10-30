public class Electronics extends Goods {

    protected double productWarranty;


    public Electronics(String name, double price, double productWarranty, double priceOfContract) {
        super(name, price);
        this.productWarranty = productWarranty;
    }


    public double priceOfProdukt(){
        super.price = price + (price * productWarranty / 100);
        return price;
    }

    public void getGoods() {
        System.out.println("The cost of " + name + " is " + priceOfProdukt() + "$ , including " + productWarranty + "% of quarantee");
    }

    public String toString(){
        return name + " " + priceOfProdukt() + "$ , including " + productWarranty + "% of quarantee";
    }


}
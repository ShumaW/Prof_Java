public class Mobile extends Electronics{
    private double priceOfContract;


    public Mobile(String name, double price, double productWarranty, double priceOfContract) {
        super(name, price, productWarranty, priceOfContract);
        this.priceOfContract = priceOfContract;
    }



    public double getPriceOfProdukt(){
        this.price = super.getPriceOfProdukt() + priceOfContract;
        return price;
    }

    public void getGoods() {
        System.out.println("The cost of " + name + " is " + this.getPriceOfProdukt() + "$ , including " + super.productWarranty + "% of quaranty and " + priceOfContract + "$ price of contract with mobile services for one year.");
    }
    public String toString(){
        return name + " cost " + this.getPriceOfProdukt() + "$ , including " + super.productWarranty + "% of quaranty and " + priceOfContract + "$ price of contract with mobile services for one year." ;
    }
}
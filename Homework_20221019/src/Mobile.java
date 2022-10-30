public class Mobile extends Electronics{
    private double priceOfContract;


    public Mobile(String name, double price, double productWarranty, double priceOfContract) {
        super(name, price, productWarranty, priceOfContract);
        this.priceOfContract = priceOfContract;
    }

    private double priceWithContract() {
        return price + (price*super.productWarranty) + priceOfContract;
    }

    public void getGoods() {
        System.out.println("The cost of " + name + " is " + priceWithContract() + "$ , with " + super.productWarranty + "% of quaranty and " + priceOfContract + "$ price of contract with mobile services for one year.");
    }
}
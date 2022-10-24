public class Electronics extends Goods{

    private double productWarranty;
    private double priceOfContract;

    public Electronics(String name, double price, double productWarranty, double priceOfContract) {
        super(name, price);
        this.productWarranty = productWarranty;
        this.priceOfContract = priceOfContract;
    }

    private double priceWithQuarantee(){
        return price + (price * productWarranty);
    }

    public void getGoods(){
        System.out.println("The cost of " + name + " is " + priceWithQuarantee() + "$ , with " + productWarranty + "% of quarantee");
    }

    private double priceWithContract (){
        return price + priceOfContract;
    }

    public void getMobile(){
        System.out.println("The cost of " + name + " is " + priceWithContract() + "$ , with " + priceOfContract + "$ price of contract with mobile services for one year.");
    }
}

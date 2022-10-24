public class Electronics extends Goods {

    protected double productWarranty;


    public Electronics(String name, double price, double productWarranty, double priceOfContract) {
        super(name, price);
        this.productWarranty = productWarranty;
    }

    public double priceWithQuarantee() {
        return price + (price * productWarranty);
    }

    public void getGoods() {
        System.out.println("The cost of " + name + " is " + priceWithQuarantee() + "$ , with " + productWarranty + "% of quarantee");
    }


}

public abstract class Goods {
    protected String name;
    protected double price;



    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void getGoods(){
    }

    public double getPriceOfProdukt(){
        return price;
    }



}
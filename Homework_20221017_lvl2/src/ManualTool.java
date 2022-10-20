public class ManualTool extends  Tool{
    private String type;

    public ManualTool(String name, String brand, double price, double weight, String type) {
        super(name, brand, price, weight);
        this.type = type;
    }

    @Override
    public String toString() {
        return "ManualTool  {" + "  Name =" + name + " , brand =" + brand + " , price =" + price + " , weight=" + weight +
                " , type='" + type + '\'' +
                '}';
    }
}

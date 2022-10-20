public class ElectricTool extends Tool {
    private String typeOfPower;
    private String functionOfСhiselling;
    private String cartridge;

    public ElectricTool(String name, String brand, double price, double weight, String typeOfPower, String functionOfСhiselling, String cartridge) {
        super(name, brand, price, weight);
        this.typeOfPower = typeOfPower;
        this.functionOfСhiselling = functionOfСhiselling;
        this.cartridge = cartridge;
    }

    @Override
    public String toString() {
        return "ElectricTool  {" + "  Name =" + name + " , brand =" + brand + " , price =" + price + " , weight=" + weight +
                " , typeOfPower='" + typeOfPower + '\'' +
                ", functionOfСhiselling='" + functionOfСhiselling + '\'' +
                ", cartridge='" + cartridge + '\'' +
                '}' ;
    }
}

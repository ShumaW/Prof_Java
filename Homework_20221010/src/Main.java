public class Main {
    public static void main(String[] args) {

        Auto auto1 = new Auto();
        auto1.brand = "Renault";
        auto1.model = "Megane III";
        auto1.year = 2011;
        auto1.color = "grey";

        Auto auto2 = new Auto();
        auto2.brand = "Fiat";
        auto2.model = "Punto";
        auto2.year = 2008;
        auto2.color = "dark blue";

        Auto auto3 = new Auto();
        auto3.brand = "Ferarri";
        auto3.model = "California";
        auto3.year = 2021;
        auto3.color = "red";

 //       print(auto1);
         Auto [] arr = {auto1, auto2, auto3};

         printArray(arr);
    }

    public static void print(Auto auto) {
        System.out.println("Brand auto - " + auto.brand);
        System.out.println("Model auto - " + auto.model);
        System.out.println("Year of issue - " + auto.year);
        System.out.println("Color auto - " + auto.color);
        System.out.println();
    }

    public static void printArray(Auto[] arr) {
        for (int i = 0; i < arr.length; i++) {
            print(arr[i]);
        }
    }
}
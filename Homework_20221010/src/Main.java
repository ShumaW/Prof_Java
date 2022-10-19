public class Main {
    public static void main(String[] args) {

        Auto auto1 = new Auto("Renault","Megane III", 2011,  "grey");
        Auto auto2 = new Auto("Fiat", "Punto",2008,"dark blue");
        Auto auto3 = new Auto( "Ferarri", "California", 2021, "red");

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
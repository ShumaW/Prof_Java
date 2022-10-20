public class Main {
    public static void main(String[] args) {

        /*
         Представьте, вы пишите программу для on-line магазина (или для школы,
         для больницы, для отеля….) . выберете любую предметную область.
         Опишите несколько классов и создайте несколько объектов для выбранной предметной области.
         */

        Tool[] tools = {new ElectricTool("Drill", "BWT", 56.25, 0.9, "Electrik", "No", "SDS"),
                new ElectricTool("Driil", "DM", 48.05, 1.5, "Battery", "Yes", "SDS"),
                new ManualTool("Hammer", "LKW", 15.99, 1.5, "Hand")
        };

        System.out.println("--------------- Level 2 ---------------------");
        for (Tool t : tools) {
            System.out.println(t);
        }
    }
}
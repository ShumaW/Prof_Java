package Part_1;

/**
 * 1) Создать абстрактный класс(контракт) для автосалона. Придумать общие свойства
 * для автомобилей
 * 2) Реализовать несколько конкретных классов автомобилей.
 * 3) Сделать класс для управления автосалоном
 * 4) Добавить в систему интерфейс. Вынести в него контракт для создания автомобилей
 * и мотоциклов
 */

public class MainOne {
    public static void main(String[] args) {

        Cars bmw = new BMW("X5", 2015, 210);
        Cars audi = new Audi("A5", 2009, 180);

        System.out.println("-".repeat(50));

        System.out.println(bmw);
        bmw.oldOrNewCar();
        bmw.sportCar();

        System.out.println("-".repeat(50));
        System.out.println(audi);
        audi.oldOrNewCar();
        audi.sportCar();

        System.out.println("-".repeat(50));
        AutoManager car = new AutoManager();
        System.out.println(car.cars(new BMW("X6", 2016, 256)));
        car.cars(new BMW("X6", 2016, 256)).sportCar();
        car.cars(new BMW("X7", 2020, 280)).oldOrNewCar();

        System.out.println("-".repeat(50));

        AutoManager motorbike = new AutoManager();
        System.out.println(motorbike.motorbikes(new Motorbikes("Harley", 1998, 220)));

    }
}
package org.example.generator;

import com.github.javafaker.Faker;
import org.example.entity.Brand;
import org.example.entity.Car;
import org.example.entity.Color;
import org.example.entity.Developer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Generator {

    static Faker faker = new Faker();
    static Random random = new Random();

    public static Color randomColor(){
        Color[] colors = Color.values();
        return colors[random.nextInt(colors.length)];
    }

    public static Brand randomBrand(){
        Brand[] brands = Brand.values();
        return brands[random.nextInt(brands.length)];
    }

    private static int getRandomMaxSpeed(){
        return faker.number().numberBetween(100,500);
    }


    public static boolean randomSports(){
        return getRandomMaxSpeed() > 250;
    }

    public static Car getCar() {
        return new Car(
           randomColor(), randomSports(), randomBrand(), getRandomMaxSpeed()
        );
    }

    public static char getGender(){
        char[] gender = {'m', 'f'};
        return gender[random.nextInt(gender.length)];
    }

    public static List<Developer> getListDevelopers(int length) {
        List<Developer> list = new ArrayList<>();
        int count = 1;
       while (count <= length) {

            list.add(new Developer(
                    faker.name().name(),
                    faker.name().lastName(),
                    random.nextInt(65),
                    random.nextDouble(1000,5000),
                    getGender(),
                    getCar()
                    ));
            count++;
        }
        return list;
    }
}

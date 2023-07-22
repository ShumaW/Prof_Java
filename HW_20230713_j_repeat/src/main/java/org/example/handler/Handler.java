package org.example.handler;

import org.example.entity.Car;
import org.example.entity.Developer;
import org.example.generator.Generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Handler {

    static List<Developer> developers = Generator.getListDevelopers(10);

    public static List<Developer> getListMansWithSportCar() {
        return developers.stream()
                .filter(dev -> dev.getGender() == 'm')
                .filter(developer -> developer.getCar().isSports())
                .toList();
    }

    public static Map<Character, List<Developer>> groupingByGender() {
        Map<Character, List<Developer>> map = developers.stream()
                .collect(Collectors.groupingBy(Developer::getGender));
        return map;
    }

    public static Map<String, Integer> getMapOfDevelopers(){

        return developers.stream()
                .collect(Collectors.toMap(dev -> dev.getName() + " " + dev.getLastName(),
                        dev -> dev.getCar().getMaxSpeed()));
    }

    public static void writeToFile(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            for (Developer dev : developers) {
                writer.write(dev.getName() + " " + dev.getLastName() +
                        "-[auto: " + dev.getCar().getBrand() +
                        "::: salary: " + dev.getSalary() + "]" + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package org.example;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Main {
    public static void main(String[] args) {

        /*
        1) Составить список времен начала всех занятий по Java на февраль, если предположить,
           что они будут проходить каждый понедельник/среду c 9:30 CET.
         */

        System.out.println("-".repeat(25) + " Task 1 " + "-".repeat(25));

        DayOfWeek dayOfWeek = LocalDate.of(2023, 2, 1).getDayOfWeek();
        LocalDate startFeb = LocalDate.of(2023, 2, 1);
        LocalDate endFeb = LocalDate.of(2023, 2, 28);
        LocalTime timeToStart = LocalTime.of(9, 30);
        TemporalAdjuster monday = TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY);
        TemporalAdjuster wednesday = TemporalAdjusters.nextOrSame(DayOfWeek.WEDNESDAY);
        LocalDate date1 = startFeb.with(wednesday);
        LocalDate date2 = startFeb.with(monday);

        System.out.println(dayOfWeek);
        date1.datesUntil(endFeb, Period.ofDays(7)).forEach(s -> {
            System.out.println(s + " " + timeToStart);
        });
        System.out.println("MONDAY");
        date2.datesUntil(endFeb, Period.ofDays(7)).forEach(s -> {
            System.out.println(s + " " + timeToStart);
        });

        /*
        2)* Рейс из Лос-Анджелеса во Франкфурт отправляется в 15:05 по местному времени и длится 10 ч. 50 м.
            Во сколько он прилетит? Написать метод, который мог бы совершать подобные вычисления.
         */

        System.out.println("-".repeat(25) + " Task 2 " + "-".repeat(25));

        getTimeToArrival(ZoneId.of("America/Los_Angeles"), ZoneId.of("Etc/GMT+1"), 650 );


    }

    private static void getTimeToArrival(ZoneId leavingZone, ZoneId arrivingZone, int timeInMinute) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm a");

        LocalDateTime leaving = LocalDateTime.of(2023, Month.FEBRUARY, 23, 15, 05);

        ZonedDateTime departure = ZonedDateTime.of(leaving, leavingZone);

        String out1 = departure.format(format);
        System.out.printf("LEAVING:  %s (%s)%n", out1, leavingZone);

        String arrivalСity = "Europe/Frankfurt";

        ZonedDateTime arrival = departure.withZoneSameInstant(arrivingZone)
                .plusMinutes(timeInMinute);

        String out2 = arrival.format(format);
        System.out.printf("ARRIVING: %s (%s)%n", out2, arrivalСity);
    }


}
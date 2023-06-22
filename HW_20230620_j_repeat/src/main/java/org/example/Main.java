package org.example;

import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();

        Storage storage = new Storage();

        storage.add(new Client(faker.name().fullName(),
                faker.number().numberBetween(18,80),
                faker.idNumber().valid(),
                new ArrayList<>(List.of(
                        new BankCard(faker.business().creditCardNumber(),
                                faker.business().creditCardExpiry(),
                                Status.ACTIVE,
                                PaymentSystem.MAESTRO,
                                faker.number().numberBetween(500,10_000),
                                Currency.PLN),
                        new BankCard(faker.business().creditCardNumber(),
                                faker.business().creditCardExpiry(),
                                Status.EXPIRED,
                                PaymentSystem.MASTER_CARD,
                                faker.number().numberBetween(500,10_000),
                                Currency.EUR),
                        new BankCard(faker.business().creditCardNumber(),
                                faker.business().creditCardExpiry(),
                                Status.BLOCKED,
                                PaymentSystem.VISA,
                                faker.number().numberBetween(500,10_000),
                                Currency.USD)))));
        storage.add(new Client(faker.name().fullName(),
                faker.number().numberBetween(18,80),
                faker.idNumber().valid(),
                new ArrayList<>(List.of(
                        new BankCard(faker.business().creditCardNumber(),
                                faker.business().creditCardExpiry(),
                                Status.ACTIVE,
                                PaymentSystem.MAESTRO,
                                faker.number().numberBetween(500,10_000),
                                Currency.EUR),
                        new BankCard(faker.business().creditCardNumber(),
                                faker.business().creditCardExpiry(),
                                Status.EXPIRED,
                                PaymentSystem.VISA,
                                faker.number().numberBetween(500,1_000_000),
                                Currency.USD),
                        new BankCard(faker.business().creditCardNumber(),
                                faker.business().creditCardExpiry(),
                                Status.ACTIVE,
                                PaymentSystem.MASTER_CARD,
                                faker.number().numberBetween(500,1_000_000),
                                Currency.EUR)))));
        storage.add(new Client(faker.name().fullName(),
                faker.number().numberBetween(18,80),
                faker.idNumber().valid(),
                new ArrayList<>(List.of(
                        new BankCard(faker.business().creditCardNumber(),
                                faker.business().creditCardExpiry(),
                                Status.EXPIRED,
                                PaymentSystem.MAESTRO,
                                faker.number().numberBetween(500,1_000_000),
                                Currency.CHF),
                        new BankCard(faker.business().creditCardNumber(),
                                faker.business().creditCardExpiry(),
                                Status.EXPIRED,
                                PaymentSystem.MASTER_CARD,
                                faker.number().numberBetween(500,1_000_000),
                                Currency.EUR),
                        new BankCard(faker.business().creditCardNumber(),
                                faker.business().creditCardExpiry(),
                                Status.BLOCKED,
                                PaymentSystem.MAESTRO,
                                faker.number().numberBetween(500,1_000_000),
                                Currency.EUR)))));

        storage.printMap();

    }
}
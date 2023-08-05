package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Generator {
    static List<String> codesCard = Arrays.asList("1234567887654321",
            "8745692136548974",
            "2645832116459874",
            "5564123987451236",
            "6644552233115544",
            "5663321149877896",
            "9988774455663322",
            "1111222233344455",
            "6665554455662211",
            "8523665588771133");

    static List<String> datesValid = Arrays.asList("0125",
            "0225",
            "0325",
            "0425",
            "0525",
            "0625",
            "0725",
            "0825",
            "0925",
            "1025");

    static List<String> CVV = Arrays.asList("123",
            "456",
            "789",
            "321",
            "654",
            "987",
            "147",
            "258",
            "369",
            "741",
            "852",
            "963");

    static List<String> names = Arrays.asList("Mike",
            "Sem",
            "Ann",
            "John",
            "Jack",
            "Nick",
            "Judith",
            "Eric",
            "Daniel",
            "Karla",
            "Ursula",
            "Johnny");

    static List<String> lastName = Arrays.asList(
            "Smith",
            "Jackson",
            "Gates",
            "Gans",
            "Depp",
            "Nicholson",
            "Ford",
            "Lodbrock");

    static Random random = new Random();

    public static String addBankCard() {
        return codesCard.get(random.nextInt(codesCard.size()))
                + datesValid.get(random.nextInt(datesValid.size()))
                + CVV.get(random.nextInt(CVV.size()));
    }

    public static String addNameOfClient() {
        return names.get(random.nextInt(names.size())) + " " + lastName.get(random.nextInt(lastName.size()));
    }

    public static double getBalance() {
        return random.nextDouble(1_000_000);
    }

    public static Currency getRandomCurrency(){
        Currency[] currencies = Currency.values();
        return currencies[random.nextInt(currencies.length)];
    }

    public static Status getStatusBankCard(){
        Status[] statuses = Status.values();
        return statuses[random.nextInt(statuses.length)];
    }
}

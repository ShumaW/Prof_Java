package org.example;

import lombok.*;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class Client implements Comparable<Client>{

    private String name;

    private int age;

    private String passNumber;

    private List<BankCard> bankCardList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return age == client.age && Objects.equals(name, client.name) && Objects.equals(passNumber, client.passNumber) && Objects.equals(bankCardList, client.bankCardList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, passNumber, bankCardList);
    }

    @Override
    public int compareTo(Client o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Client: " + name + ", age - " + age + ", passNumber - " + passNumber + ", bankCardList: " + bankCardList + "\n";
    }
}

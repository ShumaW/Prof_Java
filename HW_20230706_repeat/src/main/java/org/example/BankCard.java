package org.example;

import lombok.Getter;

@Getter
public record BankCard(String bankCard, Currency currency, Status status) {

    @Override
    public String toString() {
        return "BankCard: " + bankCard + ", currency: " + currency + ", status: " + status;
    }
}

package org.example;

public class BankCard {
    private final String bankCard;
    private final Currency currency;
    private final Status status;

    public BankCard(Currency currency, Status status) {
        this.bankCard = Generator.addBankCard();
        this.currency = currency;
        this.status = status;
    }

    public String getBankCard() {
        return bankCard;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "BankCard: " + bankCard +", currency: " + currency + ", status: " + status;
    }
}

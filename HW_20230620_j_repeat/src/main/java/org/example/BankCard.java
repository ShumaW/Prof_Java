package org.example;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BankCard {
    private String numberOfCard;
    private String dataOfEnd;
    private Status status;
    private PaymentSystem paymentSystem;
    private int accountBalance;

    private Currency currency;

}

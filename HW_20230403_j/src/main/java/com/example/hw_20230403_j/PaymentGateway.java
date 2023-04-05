package com.example.hw_20230403_j;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class PaymentGateway {

    private Order order;




    @Override
    public String toString() {
        return "ordering " + this.order.getItem() + " | price: " + this.order.getPrice();
    }
}

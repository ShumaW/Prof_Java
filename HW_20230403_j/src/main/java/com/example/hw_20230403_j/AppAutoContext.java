package com.example.hw_20230403_j;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.hw_20230403_j")
//@SpringBootApplication
public class AppAutoContext {

    @Bean
    public PaymentGateway gateway1(){
        PaymentGateway paymentGateway = new PaymentGateway();
        paymentGateway.setOrder(new Order("Headphone", 250.95));
        return paymentGateway;
    }

    @Bean
    public PaymentGateway gateway2(){
        PaymentGateway paymentGateway = new PaymentGateway();
        paymentGateway.setOrder(new Order("IPhone 14", 599.99));
        return paymentGateway;
    }

}

package org.example.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer productId;
    private String category;
    private String name;
    private Factory factory;
    private Long quantity;
    private Boolean isPacked;
    private Boolean isAdv;
    private Double price;
    private Double margin;
    private Boolean isDept;

    @Override
    public String toString() {
        return "ProductId: " + productId +
                ", category: " + category +
                ", name: " + name +
                ", factory: " + factory +
                ", quantity: " + quantity +
                ", isPacked: " + isPacked +
                ", isAdv: " + isAdv +
                ", price: " + price +
                ", margin: " + margin +
                ", isDept: " + isDept + "\n";
    }


}

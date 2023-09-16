package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CA {

    private final ShapeType shapeType;

    public CA(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    public double calculateArea(double... params) {
        if (shapeType == ShapeType.CIRCLE) { // 1 - круг
            double radius = params[0];
            return Math.PI * radius * radius;
        } else if (shapeType == ShapeType.SQUARE) { // 2 - квадрат
            double side = params[0];
            return side * side;
        } else if (shapeType == ShapeType.TRIANGLE) { // 3 - треугольник
            double a = params[0];
            double b = params[1];
            double c = params[2];
            double s = (a + b + c) / 2;
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }
        return 0.0;
    }
}

enum ShapeType {
    CIRCLE,
    SQUARE,
    TRIANGLE
}
package org.example;

public class Shape {
    private final Type type;
    private final double parameter;

    public Shape(Type type, double parameter) {
        this.type = type;
        this.parameter = parameter;
    }

    public double calculateArea() {
        if (type == Type.CIRCLE) {

        } else if (type == Type.SQUARE) {

        }
        return 0.0;
    }
}

enum Type {CIRCLE, SQUARE}
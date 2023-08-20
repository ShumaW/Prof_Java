package org.example.entity;

import lombok.*;

import java.util.*;

@Getter
@Setter
public class Factory implements Comparable<Factory>{

    private String factoryName;

    public static final List<String> factoryList = new ArrayList<>();
    public Factory(String factoryName) {
        this.factoryName = factoryName;
        factoryList.add(factoryName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factory factory = (Factory) o;
        return Objects.equals(factoryName, factory.factoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(factoryName);
    }

    @Override
    public String toString() {
        return factoryName;
    }


    @Override
    public int compareTo(Factory o) {
        return this.factoryName.compareTo(o.factoryName);
    }
}

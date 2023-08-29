package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {

    Warehouse warehouse = new Warehouse(10,0);
    @Test
    void warehouseCapacityExceptionTest(){
        assertThrows(IllegalArgumentException.class, () -> new Warehouse(-10,0));
    }

    @Test
    void warehouseAvailableItemsExceptionTest(){
        assertThrows(IllegalArgumentException.class, () -> new Warehouse(10,-25));
    }

    @Test
    void produceAmountExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> warehouse.produce(-25));
    }

    @Test
    void consumeAmountExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> warehouse.consume(-40));
    }

    @Test
    void produceTest(){
        Warehouse w1 = new Warehouse(5,0);
        int expected = 1;
        w1.produce(1);
        assertEquals(expected, w1.getAvailableItems());
    }

    @Test
    void consumeTest(){
        Warehouse w1 = new Warehouse(5,5);
        int expected = 4;
        w1.consume(1);
        assertEquals(expected, w1.getAvailableItems());
    }
}
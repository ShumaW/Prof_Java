package Task1;

import org.junit.jupiter.api.BeforeAll;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

class TaskOneTest {
    private static TaskOne checker;

    @BeforeAll
    public static void init() {checker = new TaskOne();}


    @org.junit.jupiter.api.Test
    void addCommonElements() {
        assertTrue( checker.addCommonElements(new int[]{1, 2, 5, 5, 8, 9, 7, 10}, new int[]{1, 0, 6, 15, 6, 4, 7, 0, 5}));
        assertTrue( checker.addCommonElements(null, new int[]{2, 5, 9, 7}));
        assertTrue( checker.addCommonElements(new int[]{2,5,9,7}, null));
    }
}
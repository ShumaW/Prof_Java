package Task2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTwoTest {

    private static TaskTwo checker;
    @BeforeAll
    public static void init(){checker = new TaskTwo();}

    @Test
    void deleteRepeatingElements() {
        assertTrue(checker.deleteRepeatingElements(new int[]{1,1,1,22,22,5,5,4,4,3,3,6,6}));
        assertTrue(checker.deleteRepeatingElements(new int[]{}));
    }
}
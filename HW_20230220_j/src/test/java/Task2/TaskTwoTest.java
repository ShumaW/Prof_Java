package Task2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


class TaskTwoTest {

    @Test
    void deleteRepeatingElements() {
        int[] arr = {0, 3, -2, 4, 3, 2, 5, 5, 6, 6, 77, -2};
        int[] arr1 = null;
        TaskTwo taskTwo = new TaskTwo();
        int[] ints1 = taskTwo.deleteRepeatingElements(arr);
        assertTrue(Arrays.stream(ints1).anyMatch(x -> x == 0));
        assertTrue(Arrays.stream(ints1).anyMatch(x -> x == 77));
        assertFalse(Arrays.stream(ints1).anyMatch(Objects::isNull));
        int[] ints2 = taskTwo.deleteRepeatingElements(arr1);
        assertFalse(Arrays.stream(ints2).anyMatch(Objects::isNull));
    }
}
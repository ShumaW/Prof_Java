package Task1;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class TaskOneTest {

    @org.junit.jupiter.api.Test
    void addCommonElements() {
        Integer[] a = new Integer[]{1, 2, 5, 5, 8, 9, 7, 10};
        Integer[] b = new Integer[]{1, 0, 6, 15, 6, 4, 7, 0, 5};
        Integer[] c = null;
        Integer[] d = new Integer[]{};

        TaskOne task = new TaskOne();
        Integer[] integers = task.addCommonElements(a, b);
        assertTrue(Arrays.stream(integers).anyMatch(v -> v == 1));
        assertTrue(Arrays.stream(integers).anyMatch(v -> v == 5));
        assertTrue(Arrays.stream(integers).anyMatch(v -> v == 7));
        assertFalse(Arrays.stream(integers).anyMatch(v -> v == 9));
        assertEquals(1,integers[0]);
        assertFalse(Arrays.stream(integers).anyMatch(v -> v == null));
        Integer[] int1 = task.addCommonElements(a,d);


    }
}
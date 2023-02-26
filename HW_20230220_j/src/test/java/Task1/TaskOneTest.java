package Task1;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class TaskOneTest {

    @org.junit.jupiter.api.Test
    void addCommonElements() {
        int[] a = new int[]{1, 2, 5, 5, 8, 9, 7, 10};
        int[] b = new int[]{1, 0, 6, 15, 6, 4, 7, 0, 5};
        int[] c = null;
        int[] d = new int[]{};

        TaskOne task = new TaskOne();
        Integer[] integers = task.addCommonElements(a, b);
        assertTrue(Arrays.stream(integers).anyMatch(v -> v == 1));
        assertTrue(Arrays.stream(integers).anyMatch(v -> v == 5));
        assertTrue(Arrays.stream(integers).anyMatch(v -> v == 7));
        assertFalse(Arrays.stream(integers).anyMatch(v -> v == 9));
        assertEquals(integers[0],1);
        assertFalse(Arrays.stream(integers).anyMatch(v -> v == null));
        Integer[] int1 = task.addCommonElements(a,d);


    }
}
import java.util.Arrays;

public class Example <T> {

    private int size = 0;

    private T[] list;

    public Example( int copasity) {
        this.list = (T[]) new Object[copasity];
    }

    public void add (T element) {
        if (size >= list.length) {
            throw new RuntimeException("Collection size exceeded, copasity=" + list.length);
        }
        list[size++] = element;
    }



    @Override
    public String toString() {
        return "copasity=" + size +", list=" + Arrays.toString(list);
    }
}

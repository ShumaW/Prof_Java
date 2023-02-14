import java.util.*;

public class Main {
    public static void main(String[] args) {

        /*
        Напишите класс, который реализует ограниченную коллекцию,
        где максимальное количество элементов может быть задано в конструкторе,
        и элементы могут быть любого типа.
         */

        Example<List<Integer>> e1 = new Example<>(2);
        e1.add(List.of(1,2,3));
        e1.add(List.of(5,5,5));
        // e1.add(List.of(6,6,6));  - выдаст ошибку
        System.out.println(e1);

        Example<Set<String>> e2 = new Example<>(3);
        e2.add(Set.of("a","bb","ccc"));
        e2.add(Set.of("dddd","fffff"));
        e2.add(Set.of("a","b","c"));
//        e2.add(Set.of("g","d"));   - выдаст ошибку
        System.out.println(e2);


    }
}
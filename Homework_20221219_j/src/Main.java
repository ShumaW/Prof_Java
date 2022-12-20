import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        OurLinkedList<Integer> list = new OurLinkedList<>();
        list.append(5);
        System.out.println("-".repeat(25) + " print element " + "-".repeat(25));
        System.out.println(list.get(0));
        System.out.println(list.size());
        list.append(15);
        list.append(2);
        System.out.println("-".repeat(25) + " add elements " + "-".repeat(25));
        list.append(10);
        list.append(117);
        list.append(20);
        list.append(30);
        System.out.println("-".repeat(25) + " print element " + "-".repeat(25));
        for (Integer el : list) {
            System.out.println(el);
        }

        System.out.println("-".repeat(25) + " remove each odd element in the list " + "-".repeat(25));
        for (Integer el : list) {
            if (el%2 == 0) list.remove(el);
        }

        for (Integer el : list) {
            System.out.println(el);
        }



    }
}
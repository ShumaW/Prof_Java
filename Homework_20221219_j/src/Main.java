import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        OurLinkedList<Integer> list = new OurLinkedList<>();
        list.append(5);
        System.out.println(list.get(0));
        System.out.println(list.size());
        list.append(15);
        list.append(2);
        list.append(10);
        list.append(117);
        list.append(20);
        list.append(30);
        for (Integer el : list) {
            System.out.println(el);
        }

    }
}
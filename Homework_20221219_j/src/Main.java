import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        OurLinkedList<Integer> list = new OurLinkedList<>();
        System.out.println("-".repeat(25) + " add elements " + "-".repeat(25));
        for (int i = 0; i < 10; i++) {
            list.append(i);
        }
        for (Integer el : list) {
            System.out.println(el);
        }

        System.out.println("-".repeat(25) + " print element " + "-".repeat(25));
        System.out.println(list.get(5));

        System.out.println("-".repeat(25) + " remove each odd element in the list " + "-".repeat(25));
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()){
            if (it.next()%2 == 0 ){
                it.remove();
            }
        }

        for (Integer el : list) {
            System.out.println(el);
        }

    }
}
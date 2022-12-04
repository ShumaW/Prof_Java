import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        /*
        На основании созданного во время занятия связанного списка,
        создайте двунаправленный связанный список и реализуйте методы:

        public boolean add(Type elem) {…}

        public void add(int index, Type elem) {…}

        public Type remove (int index) {…}

         */

        var linkedList = new LinkedListImpl<String>();
        linkedList.add("Hello");
        linkedList.add("world");
        linkedList.add("!");
        linkedList.add("?");
        linkedList.add("_!");

        linkedList.add(2, "22222");

        linkedList.removeElement(3);


//        LinkedList<String> str = new LinkedList<>();
//        str.add("awefq");
//        str.add("btrwtb");
//        str.add("{kjhhhg");
//        str.add("6519");
//        System.out.println(str);
//        str.remove(0);
//        System.out.println(str);

//        linkedList.addToBegin("111");
//
        linkedList.printData();
    }

    private static class LinkedListImpl<Type> {
        private int size;
        private Node<Type> first;
        private Node<Type> last;

        public LinkedListImpl() {
            size = 0;
            first = null;
            last = null;
        }

        public boolean add(Type elem) {
            var newNode = new Node<>(elem);
            if (first == null) {
                first = newNode;
            } else {
                last.next = newNode;
                newNode.prev = last;
            }
            last = newNode;
            size++;
            return false;
        }

        public Node<Type> nodeWithIndex(int index) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("The index must have a value between 0 and " + (size - 1));
            }
            int distanceFromFirst = index;
            int distanceFromLast = size - 1 - index;
            Node<Type> currentNode;
            if (distanceFromFirst <= distanceFromLast) {
                currentNode = first;
                for (int i = 0; i < distanceFromFirst; i++) {
                    currentNode = currentNode.next;
                }
            } else {
                currentNode = last;
                for (int i = 0; i < distanceFromLast; i++) {
                    currentNode = currentNode.prev;
                }
            }
            return currentNode;
        }

        public void add(int index, Type elem) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("The index must have a value between 0 and " + (size - 1));
            }
            if (index == size) {
                add(elem);
            } else {
                Node<Type> newNode = new Node<>(elem);
                Node<Type> currentNode = nodeWithIndex(index);

                newNode.next = currentNode;
                newNode.prev = currentNode.prev;

                if (currentNode.prev == null) {
                    first = newNode;
                } else {
                    currentNode.prev.next = newNode;
                }
                currentNode.prev = newNode;
                size++;
            }
        }

        public Node<Type> removeElement(int index) {
            Node<Type> removableElement = nodeWithIndex(index);
            if (removableElement.prev == null) {
                first = removableElement.next;
            } else {
                removableElement.prev.next = removableElement.next;
            }

            if (removableElement.next == null) {
                last = removableElement.prev;
            } else {
                removableElement.next.prev = removableElement.prev;
            }

            size--;
            return removableElement;
        }

        public void printData() {
            if (first == null) {
                System.out.println("LinkedList is empty.");
            } else {
                Node<Type> currentNode = first;
                while (currentNode != null) {
                    System.out.print(currentNode.data + " ");
                    currentNode = currentNode.next;
                }
                System.out.println();
            }
        }
    }

    static final class Node<Type> {
        private Type data;
        private Node<Type> prev;
        private Node<Type> next;


        public Node(Type data) {
            this.data = data;
        }

        public Type getData() {
            return data;
        }

        public Node<Type> getPrev() {
            return prev;
        }

        public void setPrev(Node<Type> prev) {
            this.prev = prev;
        }

        public void setPrev(int index) {
            this.prev = prev;
        }

        public void setData(Type data) {
            this.data = data;
        }

        public Node<Type> getNext(Node<Type> next) {
            return next;
        }

        public void setNext(Node<Type> next) {
            this.next = next;
        }

        public void setNext(int index) {
            this.next = next;
        }

    }
}
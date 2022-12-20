import java.util.Iterator;
import java.util.NoSuchElementException;

public class OurLinkedList<E> implements OurList<E>, Iterable<E>{

    private int size;
    private Node<E> first;
    private Node<E> last;

    public OurLinkedList() {
    }

    @Override
    public void append(E value) {
        if (size > 0) {
            Node<E> newNode = new Node<>(null, last, value);
            last.next = newNode;
            last = newNode;
        } else {
            Node<E> newNode = new Node<>(null, null, value);
            first = newNode;
            last = newNode;
        }
        size++;
    }

    @Override
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> needle = getNode(index);
        return needle.value;
    }

    private Node<E> getNode(int index) {
        Node<E> needle = first;
        for (int i = 0; i < index; i++) {
            needle = needle.next;
        }
        return needle;
    }

    @Override
    public void set(E o, int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> needle = getNode(index);
        needle.value = o;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containts(E o) {
        Node<E> needle = first;
        for (int i = 0; i < size; i++) {
            if (needle.value.equals(o)) {
                return true;
            } else {
                needle = needle.next;
            }
        }
        return false;
    }

    @Override
    public boolean remove(int o) {
        Node<E> needle = first;
        for (int i = 0; i < size; i++) {
            if (needle.value.equals(o)) {
                removeByiD(i);
                return true;
            }
            needle = needle.next;
        }
        return false;
    }

    @Override
    public E removeByiD(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> nodeToRemove = getNode(index);
        Node<E> left = nodeToRemove.prev;
        Node<E> right = nodeToRemove.next;

        if (index > 0 && index < size - 1){
            nodeToRemove.next = null;
            nodeToRemove.prev = null;
            left.next = right;
            right.prev = left;
        } else if (index == 0) {
            nodeToRemove.next = null;
            right.prev = null;
            first = right;
        } else {
            nodeToRemove.prev = null;
            left.next = null;
            last = left;
        }
        size--;
        return nodeToRemove.value;
    }



    //    @Override
    public Iterator<E> iterator() {
        return new OurIterator<>(this);
    }

    class OurIterator<E> implements Iterator<E>{
        OurList<E> list;
        int pos = 0;
        public OurIterator(OurList<E> list){
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return pos < list.size();
        }

        @Override
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return list.get(pos++);
        }

        public void remove(){
            if (pos == 0) {
                throw new IllegalStateException("No current element!");
            }
            list.remove(--pos);
        }
    }

    private static class Node<E> {
        Node() {

        }

        public Node(Node<E> next, Node<E> prev, E value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }

        Node<E> next;
        Node<E> prev;
        E value;
    }
}


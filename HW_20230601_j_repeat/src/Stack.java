import java.util.NoSuchElementException;

/**
 * Задача 3 (Сложность: 4/10):
 * Создайте параметризированный класс "Stack", представляющий стек элементов. Реализуйте методы "push", "pop" и
 * "isEmpty" для добавления элемента в стек, извлечения элемента из стека и проверки, пуст ли стек соответственно.
 */
public class Stack<T> {  // LIFO
    private class Noda<T> {
        T value;
        Noda<T> next;

        public Noda(T value, Noda<T> next) {
            this.value = value;
            this.next = next;
        }
        public Noda() {
        }
    }
    private Noda<T> head;

    public void push(T elem) {  // помещаем элемент на вершину stack
        Noda<T> noda = new Noda<>();  // создаем екземпляр ноды
        noda.value = elem;  // присваиваем значению ноды значение входящего элемента
        if (head != null) {  // если стек не пустой
            noda.next = head;  // перенапрявляем ссылки ноды на голову стека
        }
        head = noda; // назначаем нашу ноду головой стека
    }
    public T pop() {
        if (head == null) {  // если стек пуст
            throw new NoSuchElementException();
        }
        head = head.next;

        return head.value;
    }
    public boolean isEmpty(){
        return head == null;
    }
}

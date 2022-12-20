public interface OurList<E> {

    void append(E o);
    E get(int index);

    void set(E o, int index);

    int size();

    boolean containts(E o);

    boolean remove(int o);

    E removeByiD(int index);

}
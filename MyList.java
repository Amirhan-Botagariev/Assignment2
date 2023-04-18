

public interface MyList<T> {
    int size();
    boolean contains(Object o);
    void add(T item);
    void add(int index, T item);
    boolean remove(T item);
    void remove(int index);
    void clear();
    T get(int index);
    int indexOf(Object o);
    int lastIndexOf(Object o);
    void sort();
}


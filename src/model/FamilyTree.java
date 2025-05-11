package model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T> implements Iterable<T>, Serializable {
    private static final long serialVersionUID = 1L;

    private List<T> elements = new ArrayList<>();

    public void add(T element) {
        elements.add(element);
    }
    public List<T> getAll() {
        return elements;
    }


    public void sort(Comparator <? super T> comparator)  {
        Collections.sort(elements, comparator);
    }


    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }
}

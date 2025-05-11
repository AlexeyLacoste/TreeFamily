package service;

import model.FamilyTree;
import model.Person;

import java.util.Comparator;
import java.util.List;


/*
 * Сервис для операций над универсальным деревом: добавление, сортировка, получение
 * Универсален для любого типа T.
 */
public class DataService<T> {
    private final FamilyTree<T> tree;

    public DataService(FamilyTree<T> tree) {
        this.tree = tree;
    }

    /** Добавить элемент в дерево */
    public void add(T element) {
        tree.add(element);
    }

    /** Сортировка элементов по заданному компаратору */
    public void sort(Comparator<? super T> comparator) {
        tree.sort(comparator);
    }

    /** Получить все элементы */
    public List<T> getAll() {
        return tree.getAll();
    }
}

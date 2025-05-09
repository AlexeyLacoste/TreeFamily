package service;

import model.FamilyTree;
import model.Person;

import java.util.List;

public class DataService {
    private FamilyTree tree;

    public DataService(FamilyTree tree) {
        this.tree = tree;
    }

    // Добавляет человека в дерево
    public void add(Person person) {
        tree.addPerson(person);
    }

    // Сортировка по имени
    public void sortByName() {
        tree.sortByName();
    }

    // Сортировка по году рождения
    public void sortByBirthYear() {
        tree.sortByBirthYear();
    }

    // Получить всех людей
    public List<Person> getAll() {
        return tree.getPeople();
    }
}

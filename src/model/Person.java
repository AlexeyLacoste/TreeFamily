package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Модель человека для семейного древа
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String name;
    private final int birthYear;
    private Person mother;
    private Person father;
    private final List<Person> children;

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    /**
     * Добавить ребёнка к этому человеку
     */
    public void addChild(Person child) {
        if (child != null && !children.contains(child)) {
            children.add(child);
        }
    }

    /**
     * Установить мать и добавить в её список детей
     */
    public void setMother(Person mother) {
        if (this.mother != mother) {
            this.mother = mother;
            if (mother != null) {
                mother.addChild(this);
            }
        }
    }

    /**
     * Установить отца и добавить в его список детей
     */
    public void setFather(Person father) {
        if (this.father != father) {
            this.father = father;
            if (father != null) {
                father.addChild(this);
            }
        }
    }

    /**
     * Возвращает список детей (неизменяемый)
     */
    public List<Person> getChildren() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public String toString() {
        return name + " (" + birthYear + ")";
    }
}

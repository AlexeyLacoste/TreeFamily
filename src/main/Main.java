package main;
import model.FamilyTree;
import model.Person;
import service.DataHandler;
import service.TextDataStorage;
import model.BinaryFileStorage;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();

        Person igor = new Person("Игорь",1971);
        Person elena = new Person("Елена", 1971);
        Person alexey = new Person("Алексей",1993);
        Person lubov = new Person("Любовь", 1992);
        Person vladimir = new Person("Владимир", 1962);
        Person marina = new Person("Марина", 1962);
        Person mihail = new Person("Михаил", 1985);

        alexey.setMother(elena);
        alexey.setFather(igor);
        lubov.setFather(vladimir);
        lubov.setMother(marina);
        mihail.setMother(marina);
        mihail.setFather(vladimir);


        tree.addPerson(igor);
        tree.addPerson(elena);
        tree.addPerson(alexey);
        tree.addPerson(lubov);
        tree.addPerson(vladimir);
        tree.addPerson(marina);
        tree.addPerson(mihail);

        // Сохраняем
        DataHandler<FamilyTree> handler = new DataHandler<>();
        handler.saveToFile(tree, "tree.dat");

        // Загружаем
        FamilyTree loadedTree = handler.loadFromFile("tree.dat");

        // Проверим вывод
        if (loadedTree != null) {
            System.out.println("\n📂 Загруженное дерево:");
            for (Person p : loadedTree) {
                System.out.println(p);
            }
        }
    }
}



package main;
import model.FamilyTree;
import model.Person;
import service.DataHandler;
import service.DataService;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Работа с людьми

        FamilyTree<Person> humanTree = new FamilyTree<>();
        DataService<Person> humanService = new DataService<>(humanTree);

        humanService.add(new Person("Игорь", 1971));
        humanService.add(new Person("Елена", 1971));
        humanService.add(new Person("Алексей", 1993));
        humanService.add(new Person("Любовь", 1992));
        humanService.add(new Person("Владимир", 1962));
        humanService.add(new Person("Марина", 1962));
        humanService.add(new Person("Михаил", 1985));

        System.out.println("Люди до сортировки: ");
        humanService.getAll().forEach(System.out::println);

        // Сортировка по имени
        humanService.sort(Comparator.comparing(Person::getName));
        System.out.println("\nЛюди после сортировки по имени: ");


        // Сортировка по году рождения
        humanService.sort(Comparator.comparingInt(Person::getBirthYear));
        System.out.println("\nЛюди после сортировки по году рождения: ");
        humanService.getAll().forEach(System.out::println);



        // Пример сохранения\ загрузки людей
        DataHandler<FamilyTree<Person>> handler = new DataHandler<>();
        String filename = "humans.dat";
        try {
            handler.save(humanTree, "humans.dat");
            FamilyTree<Person> loaded = handler.load("humans.dat");
            System.out.println("\n Загруженные люди из файла: ");
            loaded.forEach(System.out::println);
        } catch (Exception e) {
            System.err.println("Ошибка при сериализации: " + e.getMessage());;
        }

    }
}



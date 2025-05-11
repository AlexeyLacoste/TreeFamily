package ui;

import model.FamilyTree;
import model.Person;
import service.DataHandler;
import service.FileOperations;
import service.PersonService;

import java.io.IOException;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.Comparator;
import java.util.Scanner;

public class ConsoleApp {
     private FamilyTree<Person> tree = new FamilyTree<>();
     private PersonService ps = new PersonService();
     private Scanner scanner = new Scanner(System.in);

     public void run() {
         initSample();

         System.out.println("Введите имядля показа связей");
         String name = scanner.nextLine();
         Person target = tree.getAll().stream()
                 .filter(p -> p.getName().equalsIgnoreCase(name))
                 .findFirst()
                 .orElse(null);

         if (target == null) {
             System.out.println("Человек не найден");
             return;
         }

         System.out.println("Мать: "    + ps.getMother(target));
         System.out.println("Отец: "    + ps.getFather(target));
         System.out.println("Дети: "    + ps.getChildren(target));
         System.out.println("Сиблинги: " + ps.getSiblings(target));
         System.out.println("Деды/бабки: " + ps.getGrandparents(target));
     }
     private void initSample() {
         // СОздаем примеры
         Person igor = new Person("Игорь", 1971);
         Person elena = new Person("Елена", 1971);
         Person alexey = new Person("Алексей", 1993);
         alexey.setMother(elena); alexey.setFather(igor);
         tree.add(igor); tree.add(elena); tree.add(alexey);
     }




    public static void main(String[] args) {
        new ConsoleApp().run();
    }


}

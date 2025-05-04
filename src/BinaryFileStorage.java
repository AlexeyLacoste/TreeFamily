import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class BinaryFileStorage implements TextDataStorage {


    @Override
    public void save(FamilyTree tree, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Person person : tree.people()) {
                String line = person.getName() + ";" + person.getBirthYear();

            // Если есть отце/мать, добавим их имена
                if (person.getFather() != null) {
                    line += ";" + person.getFather().getName();
                }
                if (person.getMother() != null) {
                    line += ";" + person.getMother().getName();
                }
                writer.write(line);
                writer.newLine(); // переход на новую строку
            }
            System.out.println("Семейное древо сохранено в ТХТ : " + fileName);
        }
    }

    @Override
    public FamilyTree load(String fileName) throws IOException {
        FamilyTree tree = new FamilyTree();
        Map<String, Person> nameMap = new HashMap<>();

        //Сначала создаем всех людей
        try (BufferedReader  reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String name = parts[0];
                int birthYear = Integer.parseInt(parts[1]);

                Person person = new Person(name, birthYear);
                tree.addPerson(person);
                nameMap.put(name,person); // для последующей привязки родителей
            }
        }

        //Повторно читаем и устанавливаем родителей
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String name = parts[0];
                Person person = nameMap.get(name);

                if (parts.length > 2) {
                    Person father = nameMap.get(parts[2]);
                    person.setFather(father);
                }
                if (parts.length > 3) {
                    Person mother = nameMap.get(parts[3]);
                    person.setMother(mother);
                }
            }
        }
        System.out.println("TXT файл загружен: " + fileName);
        return tree;
    }
}

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private static final long serialVersionUID = 1L;


    public List<Person> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        people.add(person);

    }

    public Person findPersonByName(String name) {
        for (Person p : people) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public List<Person> getChildren(String name) {
        Person parent = findPersonByName(name);
        return parent != null ? parent.getChildren() : new ArrayList<>();
    }
    public void printTreeForPerson(String name){
        Person root = findPersonByName(name);
        if (root != null) {
            printPersonRecursive(root, 0);
        } else {
            System.out.println("Человек не найден.");
        }
    }
    private void printPersonRecursive(Person person, int level) {
        System.out.println("  ".repeat(level) + person.getName() + "( р. " + person.getBirthYear() + ")");
        for (Person child : person.getChildren()){
            printPersonRecursive(child, level + 1);
        }
    }

    public List<Person> people() {
        return people;
    }
}
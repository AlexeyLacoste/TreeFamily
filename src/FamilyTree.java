import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Person> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }
    public void addPerson(Person person){
        people.add(person);

    }

    public Person findPersonByName(String name){
        for (Person person : people) {
            if (person.getName().equalsIgnoreCase(name)) {
                return person;
            }
        }
        return null;
    }
    public List<Person> getChildren(String name) {
        Person person = findPersonByName(name);
        if (person != null) {
            return person.getChildren();
        }
        return new ArrayList<>();
    }
    public List<Person> getSiblings(String name){
        Person person = findPersonByName(name);

        List<Person> siblings = new ArrayList<>();
        Person mother = person.getMother();
        if (mother != null){
            for (Person child : mother.getChildren()){
                if (!child.equals(person)) {
                    siblings.add(child);
                }
            }
        }
        return siblings;
    }
    public void printTree() {
        for (Person person : people) {
            System.out.println(person);
        }
    }
}

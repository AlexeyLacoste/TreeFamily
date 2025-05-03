import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int birthYear;
    private Person mother;
    private Person father;
    private List<Person> children;

    public Person (String name, int birthYear){
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

    public List<Person> getChildren() {
        return children;
    }

    public void setMother(Person mother) {
        this.mother = mother;
            if (mother != null) {
                mother.addChild(this);
            }
    }

    public void setFather(Person father) {
        this.father = father;
        if (father != null) {
            father.addChild(this);
        }

    }

    public void addChild(Person child){
        if (!children.contains(child)) {
            children.add(child);
        }
    }

    @Override
    public String toString() {
        return name + " (p. " + birthYear + ")";
    }
}

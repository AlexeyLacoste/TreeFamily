package service;

import model.Person;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Сервис для получения родственных связей для Person
 */
public class PersonService {
    /** Возвращает мать */
    public Person getMother(Person p) {
        return p.getMother();
    }

    /** Возвращает отца */
    public Person getFather(Person p) {
        return p.getFather();
    }

    /** Возвращает список детей */
    public List<Person> getChildren(Person p) {
        return p.getChildren();
    }

    /** Возвращает список братьев и сестёр через потоки */
    public List<Person> getSiblings(Person p) {
        return Stream.of(p.getMother(), p.getFather())
                .filter(Objects::nonNull)
                .flatMap(parent -> parent.getChildren().stream())
                .filter(c -> !c.equals(p))
                .distinct()
                .collect(Collectors.toList());
    }

    /** Возвращает список бабушек и дедушек */
    public List<Person> getGrandparents(Person p) {
        return getAncestors(p, 2);
    }

    /**
     * Общий метод для получения предков на указанном уровне:
     * 1 — родители, 2 — бабушки/дедушки и т.д.
     */
    private List<Person> getAncestors(Person p, int generation) {
        return Stream.iterate(
                        Stream.of(p).filter(Objects::nonNull),
                        s -> s.flatMap(person -> Stream.of(person.getMother(), person.getFather())
                                .filter(Objects::nonNull))
                )
                .skip(generation)
                .findFirst()
                .orElse(Stream.empty())
                .distinct()
                .collect(Collectors.toList());
    }
}

package service;

import model.FamilyTree;
import model.Person;

import java.io.IOException;

public interface TextDataStorage extends DataStorage {
    void save(FamilyTree<Person> tree, String filename) throws IOException;
    FamilyTree<Person> load(String filename) throws IOException;
}

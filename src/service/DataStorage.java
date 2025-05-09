package service;

import model.FamilyTree;

import java.io.IOException;

public interface DataStorage {
    void save(FamilyTree tree, String fileName) throws IOException;
    FamilyTree load(String fileName) throws IOException;

}

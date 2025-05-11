package service;

import model.FamilyTree;

import java.io.IOException;

public interface DataStorage<T> {
    void save(T object, String fileName) throws IOException, ClassNotFoundException;
    T load(String fileName) throws IOException, ClassNotFoundException;

}

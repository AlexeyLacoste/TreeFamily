package service;

public interface DataSaver<T> {
    void saveToFile(T object, String filename);
    T loadFromFile(String filename);
}

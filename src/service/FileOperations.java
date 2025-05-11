package service;

import java.io.IOException;

public interface FileOperations <T>{
    void save (T object, String filename) throws IOException;
    T load(String filename) throws IOException, ClassNotFoundException;
}

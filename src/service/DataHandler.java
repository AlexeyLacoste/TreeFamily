package service;

import java.io.*;

public class DataHandler<T extends Serializable> implements FileOperations<T> {
    @Override
    public void save(T object, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(object);
        }
    }

    @Override
    public T load(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            @SuppressWarnings("unchecked")
            T obj = (T) ois.readObject();
            return obj;
        }
    }
}
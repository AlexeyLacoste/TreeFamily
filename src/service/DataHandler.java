package service;

import java.io.*;

public class DataHandler<T extends Serializable> implements DataSaver<T> {
    @Override
    public void saveToFile(T object, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(object);
            System.out.println("✅ Объект успешно сохранён в файл: " + filename);
        } catch (IOException e) {
            System.err.println("❌ Ошибка при сохранении: " + e.getMessage());
        }
    }

    @Override
    public T loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Object obj = ois.readObject();
            System.out.println("✅ Объект успешно загружен из файла: " + filename);
            return (T) obj;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("❌ Ошибка при загрузке: " + e.getMessage());
            return null;
        }
    }
}

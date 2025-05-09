package model;

import service.TextDataStorage;

import java.io.*;

public class BinaryFileStorage implements TextDataStorage {

    @Override
    public void save(FamilyTree tree, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(tree);
            System.out.println("✅ Объект FamilyTree успешно сохранён в файл: " + fileName);
        } catch (IOException e) {
            System.err.println("❌ Ошибка при сохранении: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public FamilyTree load(String fileName) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Object obj = ois.readObject();
            System.out.println("✅ Объект FamilyTree успешно загружен из файла: " + fileName);
            return (FamilyTree) obj;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("❌ Ошибка при загрузке: " + e.getMessage());
            throw new IOException("Ошибка при загрузке файла: " + fileName, e);
        }
    }
}

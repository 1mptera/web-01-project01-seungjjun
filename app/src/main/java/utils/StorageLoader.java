package utils;

import models.Book;
import models.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StorageLoader {
  public List<Storage> loadStorage() throws FileNotFoundException {
    List<Storage> storages = new ArrayList<>();

    File file = new File("Storage.csv");

    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      Storage storage = parseStorage(line);
      storages.add(storage);
    }
    return storages;
  }

  private Storage parseStorage(String storage) {
    String[] storageInformation = storage.split(",");

    return new Storage(storageInformation[0]);
  }

  public void writeStorage(List<Storage> storages) throws IOException {
    FileWriter fileWriter = new FileWriter("Storage.csv");
    for (Storage storage : storages) {
      String line = storage.toCsvRow();

      fileWriter.write(line + "\n");
    }
    fileWriter.close();
  }
}

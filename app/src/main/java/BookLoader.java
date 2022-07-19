import models.Book;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookLoader {
  public List<Book> loadBooks() throws FileNotFoundException {
    List<Book> books = new ArrayList<>();

    File file = new File("Book.csv");

    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      Book book = parseBook(line);
      books.add(book);
    }
    return books;
  }

  public void writeBook(List<Book> books) throws IOException {
    FileWriter fileWriter = new FileWriter("Book.csv");
    for (Book book : books) {
      String line = book.toCsvRow();

      fileWriter.write(line + "\n");
    }
    fileWriter.close();
  }

  private Book parseBook(String book) {
    String[] bookInformation = book.split("`");

    return new Book(
        bookInformation[0],
        bookInformation[1],
        bookInformation[2],
        bookInformation[3],
        bookInformation[4],
        bookInformation[5]);
  }
}

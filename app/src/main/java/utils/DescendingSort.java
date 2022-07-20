package utils;

import models.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DescendingSort {
  private List<String> stringBooks = new ArrayList<>();
  private List<Book> descendingBooks = new ArrayList<>();

  private Book book;


  public void descending(Book book, List<Book> books) {
    this.book = book;

    ConversionToString(books);

    descendingSort(stringBooks);

    ConversionToBook();

    changeBooksToDescendingBooks(books);
  }

  public void ConversionToString(List<Book> books) {
    for(Book book : books) {
      String line = book.toCsvRow();
      stringBooks.add(line);
    }
  }

  public void descendingSort(List<String> stringBooks) {
    Collections.sort(stringBooks, Collections.reverseOrder());
  }

  public void ConversionToBook() {
    for(int i = 0; i < stringBooks.size(); i += 1) {
      String line = stringBooks.get(i);
      this.book = transform(line);
      descendingBooks.add(this.book);
    }
  }

  public Book transform(String line) {
    String[] bookInformation = line.split("`");

    return new Book(bookInformation[0]
        ,bookInformation[1]
        ,bookInformation[2]
        ,bookInformation[3]
        ,bookInformation[4]
        ,bookInformation[5]);
  }

  public void changeBooksToDescendingBooks(List<Book> books) {
    for (int i = 0; i < books.size(); i += 1) {
      books.set(i, descendingBooks.get(i));
    }
  }
}

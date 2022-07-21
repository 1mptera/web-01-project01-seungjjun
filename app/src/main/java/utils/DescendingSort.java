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

    // 내림차순 하기 위해 Book -> String 타입으로 변환
    ConversionToString(books);

    // 변환된 String 타입의 book 리스트를 내림차순
    descendingSort(stringBooks);

    // 다시 내림차순된 String 타입을 Book 타입으로 변환
    ConversionToBook();

    // 기존 Book 타입의 리스트에 저장된 요소들을 내림차순된 요소들로 바꿔주는 작업
    changeBooksToDescendingBooks(books);
  }

  public void ConversionToString(List<Book> books) {
    for (Book book : books) {
      String line = book.toCsvRow();
      stringBooks.add(line);
    }
  }

  public void descendingSort(List<String> stringBooks) {
    Collections.sort(stringBooks, Collections.reverseOrder());
  }

  public void ConversionToBook() {
    for (int i = 0; i < stringBooks.size(); i += 1) {
      String line = stringBooks.get(i);
      this.book = transform(line);
      descendingBooks.add(this.book);
    }
  }

  public Book transform(String line) {
    String[] bookInformation = line.split("`");

    return new Book(bookInformation[0]
        , bookInformation[1]
        , bookInformation[2]
        , bookInformation[3]
        , bookInformation[4]
        , bookInformation[5]);
  }

  public void changeBooksToDescendingBooks(List<Book> books) {
    for (int i = 0; i < books.size(); i += 1) {
      books.set(i, descendingBooks.get(i));
    }
  }
}

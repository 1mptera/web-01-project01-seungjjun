package utils;

import models.Book;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestsellerPanel extends JPanel {
  private List<String> stringBooks = new ArrayList<>();
  private List<Book> descendingBooks = new ArrayList<>();
  private Book book;
  private List<Book> books;

  private JPanel contentPanel;
  private JLabel bestsellerLabel;
  private JPanel bookListPanel;

  public BestsellerPanel(Book book, List<Book> books, JPanel contentPanel) {
    this.book = book;
    this.books = books;
    this.contentPanel = contentPanel;

    for(Book book1 : books) {
        String line = book1.toCsvRow();
        stringBooks.add(line);
    }

    Collections.sort(stringBooks, Collections.reverseOrder());

    for(int i = 0; i < stringBooks.size(); i += 1) {
      String line = stringBooks.get(i);
      book = transform(line);
      descendingBooks.add(book);
    }

    for (int i = 0; i < books.size(); i += 1) {
      books.set(i, descendingBooks.get(i));
    }

    this.setOpaque(false);
    bestsellerLabel();
    createWriteButton();
  }

  private Book transform(String line) {
    String[] bookInformation = line.split("`");

    return new Book(bookInformation[0]
        ,bookInformation[1]
        ,bookInformation[2]
        ,bookInformation[3]
        ,bookInformation[4]
        ,bookInformation[5]);
  }

  public void bestsellerLabel() {
    bookListPanel = new JPanel();
    bookListPanel.setLayout(new GridLayout(0, 2));
    for (Book book : books) {
      bestsellerLabel = new JLabel("평점: " + book.starRating() + "  "+ book.title());
      JButton starRating = new JButton("평점 주기");
      starRating.addActionListener(event -> {
        JFrame starRatingFrame = new StarRatingFrame(book, books, contentPanel);
      });
      bookListPanel.add(bestsellerLabel);
      bookListPanel.add(starRating);
    }

    bookListPanel.setOpaque(false);
    this.add(bookListPanel);
  }

  public void createWriteButton() {
    JPanel writeButtonPanel = new JPanel();
    JButton writeButton = new JButton("추천할 책 공유하기");

    writeButton.addActionListener(event -> {
      JFrame writeBookRecommendFrame = new WriteBookRecommendFrame(book, books, this, contentPanel);
    });

    writeButtonPanel.add(writeButton);
    writeButtonPanel.setOpaque(false);
    this.add(writeButtonPanel);
  }
}

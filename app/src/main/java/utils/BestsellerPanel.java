package utils;

import models.Book;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BestsellerPanel extends JPanel {
  private List<Book> books;
  private JLabel bestsellerLabel;

  public BestsellerPanel(List<Book> books) {
    this.books = books;

    this.setLayout(new GridLayout(0, 2));
    bestsellerLabel();
  }

  public void bestsellerLabel() {
    for(Book book : books) {
      bestsellerLabel = new JLabel(book.title());
      JButton starRating = new JButton("평점 주기");
      starRating.addActionListener(event -> {
        JFrame starRatingFrame = new StarRatingFrame(book, books);
      });
      this.add(bestsellerLabel);
      this.add(starRating);
    }
  }
}

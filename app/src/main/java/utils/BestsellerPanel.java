package utils;

import models.Book;

import javax.swing.*;
import java.util.List;

public class BestsellerPanel extends JPanel {
  private List<Book> books;

  public BestsellerPanel(List<Book> books) {
    this.books = books;
  }
}


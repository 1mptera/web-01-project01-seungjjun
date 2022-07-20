package panels;

import frames.BookDetailFrame;
import frames.StarRatingFrame;
import frames.WritingBookRecommendFrame;
import models.Book;
import utils.DescendingSort;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class BookRankingPanel extends JPanel {
  private DescendingSort descendingSort;

  private Book book;
  private List<Book> books;

  private JPanel contentPanel;
  private JLabel bookRankingLabel;
  private JPanel bookListPanel;

  public BookRankingPanel(Book book, List<Book> books, JPanel contentPanel) {
    this.book = book;
    this.books = books;
    this.contentPanel = contentPanel;

    descendingSort = new DescendingSort();

    descendingSort.descending(book, books);

    this.setOpaque(false);
    bookRankingLabel();
    createWriteButton();
  }

  public void bookRankingLabel() {
    bookListPanel = new JPanel();
    bookListPanel.setLayout(new GridLayout(0, 2));
    for (Book book : books) {
      if(!book.state().equals("DELETION")) {
        bookRankingLabel = new JLabel("평점: " + book.starRating() + "  "+ book.title());
        bookRankingLabel.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent e) {
            JFrame bookDetailFrame = new BookDetailFrame(book, books, contentPanel);
          }
        });
        JButton starRating = new JButton("평점 주기");
        starRating.addActionListener(event -> {
          JFrame starRatingFrame = new StarRatingFrame(book, books, contentPanel);
        });
        bookListPanel.add(bookRankingLabel);
        bookListPanel.add(starRating);
      }

      bookListPanel.setOpaque(false);
      this.add(bookListPanel);
      }
  }

  public void createWriteButton() {
    JPanel writeButtonPanel = new JPanel();
    JButton writeButton = new JButton("책 추천하기");

    writeButton.addActionListener(event -> {
      JFrame writeBookRecommendFrame = new WritingBookRecommendFrame(book, books, this, contentPanel);
    });

    writeButtonPanel.add(writeButton);
    writeButtonPanel.setOpaque(false);
    this.add(writeButtonPanel);
  }
}

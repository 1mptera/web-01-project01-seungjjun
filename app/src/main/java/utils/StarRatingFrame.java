package utils;

import models.Book;

import javax.swing.*;
import java.util.List;

public class StarRatingFrame extends JFrame {
  private final JFrame starRatingFrame;
  private JPanel starRatingPanel;
  private String[] star = {"⭐","⭐⭐","⭐⭐⭐","⭐⭐⭐⭐","⭐⭐⭐⭐⭐"};
  private Book book;
  private List<Book> books;

  private JComboBox starRatingComboBox;

  StarRatingFrame(Book book, List<Book> books) {
    this.book = book;
    this.books = books;

    starRatingFrame = new JFrame("별점주기");

    starRatingFrame.setSize(200,200);
    starRatingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    createContent();

    starRatingFrame.setVisible(true);
  }

  public void createContent() {
    starRatingPanel = new JPanel();
    starRatingPanel.setLayout(null);

    starRatingPanel.add(createLabel());
    starRatingPanel.add(createComboBox());
    starRatingPanel.add(createButton());

    starRatingFrame.add(starRatingPanel);
  }

  public JLabel createLabel() {
    JLabel starRatingLabel = new JLabel("별점을 선택해주세요.");
    starRatingLabel.setBounds(50, 10, 200, 20);
    return starRatingLabel;
  }

  public JComboBox createComboBox() {
    starRatingComboBox = new JComboBox(star);
    starRatingComboBox.setBounds(50,30,130,40);
    return starRatingComboBox;
  }

  private JButton createButton() {
    JButton starRatingButton = new JButton("등록하기");
    starRatingButton.addActionListener(event -> {
      book.conversionStar(String.valueOf(starRatingComboBox.getSelectedItem()));
      String star = String.valueOf(Double.parseDouble(book.starRating()) + book.star());

      book.modifyStarRating(star);

      starRatingFrame.setVisible(false);
    });
    starRatingButton.setBounds(50,70,100,30);
    return starRatingButton;
  }
}

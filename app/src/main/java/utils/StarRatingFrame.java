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

  private BestsellerPanel bestsellerPanel;
  private JPanel contentPanel;

  private JComboBox starRatingComboBox;

  private String totalStar;
  private String starRating;

  StarRatingFrame(Book book, List<Book> books, JPanel contentPanel) {
    this.book = book;
    this.books = books;
    this.contentPanel = contentPanel;

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
      calculatorStarRating();

      book.accumulator(totalStar);
      book.modifyStarRating(starRating);

      starRatingFrame.setVisible(false);

      bestsellerPanel = new BestsellerPanel(book, books, contentPanel);
      showContentPanel(bestsellerPanel);
    });
    starRatingButton.setBounds(50,70,100,30);
    return starRatingButton;
  }

  public void calculatorStarRating() {
    String count = String.valueOf(Integer.parseInt(book.clickedNumber()) + 1);
    book.plusClickedNumber(count);

    book.conversionStar(String.valueOf(starRatingComboBox.getSelectedItem()));

    totalStar = String.valueOf(
        Double.parseDouble(book.getAccumulator()) + book.star());

    starRating = String.valueOf(
        Double.parseDouble(totalStar) / Double.parseDouble(count));
  }

  private void showContentPanel(JPanel panel) {
    panel.setOpaque(false);
    contentPanel.removeAll();
    contentPanel.add(panel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
  }
}

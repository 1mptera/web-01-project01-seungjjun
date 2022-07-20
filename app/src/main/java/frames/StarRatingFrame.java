package frames;

import models.Book;
import panels.BookRankingPanel;
import utils.StarRatingCalculator;

import javax.swing.*;
import java.util.List;

public class StarRatingFrame extends JFrame {
  private StarRatingCalculator starRatingCalculator;

  private String[] star = {"⭐","⭐⭐","⭐⭐⭐","⭐⭐⭐⭐","⭐⭐⭐⭐⭐"};
  private List<Book> books;
  private Book book;

  private final JFrame starRatingFrame;

  private BookRankingPanel bookRankingPanel;
  private JPanel starRatingPanel;
  private JPanel contentPanel;

  private JComboBox starRatingComboBox;

  public StarRatingFrame(Book book, List<Book> books, JPanel contentPanel) {
    starRatingCalculator = new StarRatingCalculator();

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
      starRatingCalculator.calculateStarRating(book, starRatingComboBox);

      starRatingFrame.setVisible(false);

      bookRankingPanel = new BookRankingPanel(book, books, contentPanel);
      showContentPanel(bookRankingPanel);
    });
    starRatingButton.setBounds(50,70,100,30);
    return starRatingButton;
  }

  private void showContentPanel(JPanel panel) {
    panel.setOpaque(false);
    contentPanel.removeAll();
    contentPanel.add(panel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
  }
}

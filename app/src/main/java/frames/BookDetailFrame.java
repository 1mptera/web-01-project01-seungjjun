package frames;

import models.Book;
import utils.BestsellerPanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BookDetailFrame extends JFrame {
  private JFrame bookDetailFrame;

  private BestsellerPanel bestsellerPanel;
  private JPanel bookDetailPanel;
  private JPanel contentPanel;

  private Book book;
  private List<Book> books;

  public BookDetailFrame(Book book, List<Book> books, JPanel contentPanel) {
    this.book = book;
    this.books = books;
    this.contentPanel = contentPanel;

    bookDetailFrame = new JFrame();
    bookDetailFrame.setSize(1000, 1000);
    bookDetailFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    initContent();

    bookDetailFrame.add(bookDetailPanel);
    bookDetailFrame.setVisible(true);
  }

  private void initContent() {
    bookDetailPanel = new JPanel();
    bookDetailPanel.setLayout(null);

    bookDetailPanel.add(createContent());
    bookDetailPanel.add(createDeleteButton());
    bookDetailPanel.add(createGoBackButton());
  }

  private JLabel createContent() {
    JLabel titleLabel = new JLabel("제목: " + book.title());
    titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
    titleLabel.setBounds(10,20,800,20);
    bookDetailPanel.add(titleLabel);

    JLabel contentLabel = new JLabel();
    contentLabel.setText("<html>정보 : "
        + book.summary().replaceAll("newLine", "<br/>") + "</html>");
    contentLabel.setFont(new Font("Serif", Font.BOLD, 17));
    contentLabel.setBounds(10, 50, 1000, 700);
    return contentLabel;
  }

  private JButton createDeleteButton() {
    JButton deleteButton = new JButton("삭제하기");
    deleteButton.setBounds(850, 800, 100, 40);
    deleteButton.addActionListener(event -> {
      book.deletion();
      bookDetailFrame.setVisible(false);
      bestsellerPanel = new BestsellerPanel(book, books, contentPanel);
      showContentPanel(bestsellerPanel);
    });
    return deleteButton;
  }

  private JButton createGoBackButton() {
    JButton goBackButton = new JButton("뒤로가기");
    goBackButton.setBounds(20,800,100,40);
    goBackButton.addActionListener(event -> {
      bookDetailFrame.setVisible(false);
      bestsellerPanel = new BestsellerPanel(book, books, contentPanel);
      showContentPanel(bestsellerPanel);
    });
    return goBackButton;
  }

  private void showContentPanel(BestsellerPanel panel) {
    contentPanel.removeAll();
    contentPanel.add(panel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
  }
}

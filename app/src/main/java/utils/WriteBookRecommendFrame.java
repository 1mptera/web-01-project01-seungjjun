package utils;

import models.Book;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;


public class WriteBookRecommendFrame extends JFrame {
  private Book book;
  private List<Book> books;

  private final JFrame writeFrame;

  private JTextField titleBox;
  private JTextArea contentBox;

  private JPanel writePanel;
  private JPanel bestsellerPanel;
  private JPanel contentPanel;

  public WriteBookRecommendFrame(Book book, List<Book> books,
                                 JPanel bestsellerPanel,
                                 JPanel contentPanel) {
    this.book = book;
    this.books = books;
    this.bestsellerPanel = bestsellerPanel;
    this.contentPanel = contentPanel;

    writeFrame = new JFrame();
    writeFrame.setSize(1000, 1000);
    writeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    initContent();

    writeFrame.setVisible(true);
  }

  public void initContent() {
    writePanel = new JPanel();
    writePanel.setLayout(null);

    writePanel.add(createTitleBox());
    writePanel.add(createContentBox());
    writePanel.add(createWriteButton());

    writeFrame.add(writePanel);
  }

  private JTextField createTitleBox() {
    titleBox = new JTextField(20);
    titleBox.setText("책 제목을 써주세요.");
    titleBox.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        titleBox.setText("");
      }
    });
    titleBox.setBounds(50, 10, 900, 40);

    return titleBox;
  }

  private JTextArea createContentBox() {
    contentBox = new JTextArea();
    contentBox.setText("책 줄거리를 요약해서 써주세요.");
    contentBox.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        contentBox.setText("");
      }
    });
    contentBox.setLineWrap(true);
    contentBox.setBounds(50, 60, 900, 700);

    return contentBox;
  }

  private JButton createWriteButton() {
    JButton writingButton = new JButton("책 추천하기");
    writingButton.addActionListener(event -> {
      String sentence = titleBox.getText();
      String content = contentBox.getText();

      books.add(new Book(sentence, content));

      writeFrame.setVisible(false);

      bestsellerPanel = new BestsellerPanel(book, books, contentPanel);
      showContentPanel(bestsellerPanel);
    });

    writingButton.setBounds(850, 800, 100, 40);
    return writingButton;
  }

  private void showContentPanel(JPanel panel) {
    panel.setOpaque(false);
    contentPanel.removeAll();
    contentPanel.add(panel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
  }
}

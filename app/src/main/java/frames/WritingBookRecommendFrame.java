package frames;

import models.Book;
import panels.BookRankingPanel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;


public class WritingBookRecommendFrame extends JFrame {
  private Book book;
  private List<Book> books;

  private final JFrame writeFrame;

  private JTextField titleBox;
  private JTextArea contentBox;

  private JPanel writePanel;
  private JPanel bookRankingPanel;
  private JPanel contentPanel;

  public WritingBookRecommendFrame(Book book, List<Book> books,
                                   JPanel bookRankingPanel,
                                   JPanel contentPanel) {
    this.book = book;
    this.books = books;
    this.bookRankingPanel = bookRankingPanel;
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
    titleBox.setText("좋은 문구가 들어간 책을 추천해 주세요!!");
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
    contentBox.setText("인상깊었던 문장이나, 남들에게 공유하고 싶은 문구를 적어주세요.");
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

      bookRankingPanel = new BookRankingPanel(book, books, contentPanel);
      showBookRankingPanel(bookRankingPanel);
    });

    writingButton.setBounds(850, 800, 100, 40);
    return writingButton;
  }

  private void showBookRankingPanel(JPanel panel) {
    panel.setOpaque(false);
    contentPanel.removeAll();
    contentPanel.add(panel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
  }
}

import frames.StorageFrame;
import models.Book;
import models.Post;
import models.Storage;

import panels.BookRankingPanel;
import panels.MainPanel;
import frames.WritingFrame;
import panels.RandomSentencePanel;
import utils.BookLoader;
import utils.PostLoader;
import utils.StorageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class TotalPanel extends JPanel{
  private Image img;

  public TotalPanel(Image img) {
    this.img = img;
    setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
    setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
    setLayout(null);
  }

  public void paintComponent(Graphics g) {
    g.drawImage(img, 0, 0 ,null);
  }
}

public class DailySentence extends JFrame{
  private RandomSentencePanel randomSentencePanel;
  private Book book;

  private List<Post> posts;
  private List<Book> books;
  private List<Storage> storages;

  private JFrame frame;

  private JPanel totalPanel;
  private JPanel contentPanel;
  private JPanel menuPanel;
  private MainPanel mainPanel;

  private String mood;

  DailySentence(String mood) throws FileNotFoundException {
    randomSentencePanel = new RandomSentencePanel();

    book = new Book();

    this.mood = mood;

    posts = new ArrayList<>();
    books = new ArrayList<>();
    storages = new ArrayList<>();

    PostLoader postLoader = new PostLoader();
    posts = postLoader.loadPosts();

    BookLoader bookLoader = new BookLoader();
    books = bookLoader.loadBooks();

    StorageLoader storageLoader = new StorageLoader();
    storages = storageLoader.loadStorage();

    initFrame();
    initTotalPanel();

    postWriter();
    bookWriter();
    storageWriter();

    frame.setVisible(true);
  }

  public void initFrame() {
    frame = new JFrame("Daily Sentence");
    frame.setSize(1000, 1000);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }

  private void initTotalPanel() {
    totalPanel = new TotalPanel(new ImageIcon(
        "./app/src/main/img/MainFrameBackground.jpeg").getImage());

    frame.add(totalPanel);

    initMenuButtons();
    initContentPanel(mood);
  }

  public void initContentPanel(String mood) {
    contentPanel = new JPanel();
    contentPanel.setBounds(0,100,1000,900);
    contentPanel.setOpaque(false);

    randomSentencePanel.randomSentence(posts, storages, mood, totalPanel);

    totalPanel.add(contentPanel);
  }

  public void initMenuButtons() {
    menuPanel = new JPanel();
    menuPanel.setBounds(230,10,500,500);
    menuPanel.setOpaque(false);
    totalPanel.add(menuPanel);

    menuPanel.add(createMainButton());
    menuPanel.add(createWritingButton());
    menuPanel.add(createBestsellerButton());
    menuPanel.add(createStorageButton());
  }

  public JButton createMainButton() {
    JButton mainButton = new JButton("글 목록 보기");
    mainButton.addActionListener(event -> {
      mainPanel = new MainPanel(posts, mainPanel, contentPanel);

      showContentPanel(mainPanel);
    });

    return mainButton;
  }

  public JButton createWritingButton() {
    JButton writingButton = new JButton("글귀 작성하기");
    writingButton.addActionListener(event -> {
      JFrame writingFrame = new WritingFrame(posts, mainPanel, contentPanel, menuPanel);
    });

    return writingButton;
  }

  public JButton createBestsellerButton() {
    JButton bestsellerButton = new JButton("책 추천 순위");
    bestsellerButton.addActionListener(event -> {
      JPanel bookRankingPanel = new BookRankingPanel(book, books, contentPanel);

      showBookRankingPanel(bookRankingPanel);
    });
    return bestsellerButton;
  }

  private JButton createStorageButton() {
    JButton storageButton = new JButton("글귀 보관함");
    storageButton.addActionListener(event -> {
      JFrame storageFrame = new StorageFrame(storages);
    });
    return storageButton;
  }

  public void showBookRankingPanel(JPanel panel) {
    totalPanel.remove(randomSentencePanel.sentenceLabel);
    totalPanel.remove(randomSentencePanel.saveButton);
    contentPanel.removeAll();
    contentPanel.add(panel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
    frame.setVisible(true);
  }

  public void showContentPanel(JPanel panel) {
    mainPanel.setOpaque(false);
    showBookRankingPanel(panel);
  }

  public void postWriter() {
    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent event) {
        PostLoader postLoader = new PostLoader();
        try {
          postLoader.writePost(posts);
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    });
  }

  public void bookWriter() {
    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent event) {
        BookLoader bookLoader = new BookLoader();
        try {
          bookLoader.writeBook(books);
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    });
  }

  private void storageWriter() {
    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent event) {
        StorageLoader storageLoader = new StorageLoader();
        try {
          storageLoader.writeStorage(storages);
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    });
  }
}

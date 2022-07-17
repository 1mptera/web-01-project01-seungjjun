import models.Book;
import models.Post;
import utils.BestsellerPanel;
import utils.MainPanel;
import utils.WritingPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DailySentence extends JFrame{
  private List<Post> posts;
  private List<Book> books;

  private JFrame frame;

  private JPanel contentPanel;
  private MainPanel mainPanel;
  private String mood;

  DailySentence(String mood) throws FileNotFoundException {
    this.mood = mood;

    posts = new ArrayList<>();
    books = new ArrayList<>();

    PostLoader postLoader = new PostLoader();
    posts = postLoader.loadPosts();

    BookLoader bookLoader = new BookLoader();
    books = bookLoader.loadBooks();

    initFrame();
    initMenuButtons();
    initContentPanel(mood);

    postWriter();
    bookWriter();

    frame.setVisible(true);
  }

  public void initFrame() {
    frame = new JFrame("Daily Sentence");
    frame.setSize(800, 800);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }

  public void initContentPanel(String mood) {
    contentPanel = new JPanel();

    randomSentence(mood);

    frame.add(contentPanel);
  }

  public void initMenuButtons() {
    JPanel menuPanel = new JPanel();
    frame.add(menuPanel, BorderLayout.PAGE_START);

    menuPanel.add(createMainButton());
    menuPanel.add(createWritingButton());
    menuPanel.add(createBestsellerButton());
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
      JPanel writingPanel = new WritingPanel(posts, mainPanel, contentPanel);

      showPanel(writingPanel);
    });

    return writingButton;
  }

  public JButton createBestsellerButton() {
    JButton bestsellerButton = new JButton("베스트셀러");
    bestsellerButton.addActionListener(event -> {
      JPanel bestsellerPanel = new BestsellerPanel(books);

      showContentPanel(bestsellerPanel);
    });
    return bestsellerButton;
  }

  public void randomSentence(String mood) {
    boolean isClickedMoodEqualsRandomMood = true;
    while (isClickedMoodEqualsRandomMood) {
      Random random = new Random();

      String randomPost = String.valueOf(posts.get(random.nextInt(posts.size())));

      String postMood = parsePostMood(randomPost);
      String sentence = parsePostSentence(randomPost);

      if(postMood.equals(mood)) {
        JLabel sentenceLabel = new JLabel(sentence);
        sentenceLabel.setFont(new Font("Serif", Font.BOLD, 20));

        contentPanel.add(sentenceLabel);
        isClickedMoodEqualsRandomMood = false;
      }
    }
  }

  public String parsePostSentence(String randomPost) {
    String[] sentences = randomPost.split(",");

    return sentences[0];
  }

  public String parsePostMood(String randomPost) {
    String[] moods = randomPost.split(",");

    return moods[3];
  }

  public void showPanel(JPanel panel) {
    frame.add(panel);
    panel.setVisible(true);
    frame.setVisible(true);
  }

  public void showContentPanel(JPanel panel) {
    contentPanel.removeAll();
    contentPanel.add(panel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
    frame.setVisible(true);
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
}

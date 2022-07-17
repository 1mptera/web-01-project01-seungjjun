import models.Post;
import utils.MainPanel;
import utils.WritingPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DailySentence {
  private List<Post> posts;

  private JFrame frame;

  private JPanel contentPanel;
  private MainPanel mainPanel;

  public static void main(String[] args) {
    DailySentence application = new DailySentence();
    application.run();
  }

  public DailySentence() {
    posts = new ArrayList<>();
  }

  public void run() {
    initFrame();
    initMenuButtons();
    initContentPanel();

    frame.setVisible(true);
  }

  public void initFrame() {
    frame = new JFrame("Daily Sentence");
    frame.setSize(800, 800);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void initContentPanel() {
    contentPanel = new JPanel();
    frame.add(contentPanel);
  }

  public void initMenuButtons() {
    JPanel menuPanel = new JPanel();
    frame.add(menuPanel, BorderLayout.PAGE_START);

    menuPanel.add(createMainButton());
    menuPanel.add(createWritingButton());
  }

  public JButton createMainButton() {
    JButton mainButton = new JButton("메인 페이지");
    mainButton.addActionListener(event -> {
      mainPanel = new MainPanel(posts);
      showContentPanel(mainPanel);
    });

    return mainButton;
  }

  private JButton createWritingButton() {
    JButton writingButton = new JButton("글귀 작성하기");
    writingButton.addActionListener(event -> {
      JPanel writingPanel = new WritingPanel(posts, mainPanel, contentPanel);

      showWritingPanel(writingPanel);
    });

    return writingButton;
  }

  private void showWritingPanel(JPanel panel) {
    frame.add(panel);
    panel.setVisible(true);
    frame.setVisible(true);
  }

  private void showContentPanel(JPanel panel) {
    contentPanel.removeAll();
    contentPanel.add(panel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
    frame.setVisible(true);
  }
}

package utils;

import models.Post;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class WritingPanel extends JPanel {
  private Post post;

  private List<Post> posts;

  private JPanel mainPanel;
  private JPanel contentPanel;
  private JPanel menuPanel;
  private JPanel totalPanel;

  private String[] mood = {"인생", "동기부여", "이별", "희망"};

  public WritingPanel(List<Post> posts,
                      JPanel mainPanel,
                      JPanel contentPanel,
                      JPanel menuPanel,
                      JPanel totalPanel) {

    this.posts = posts;
    this.mainPanel = mainPanel;
    this.contentPanel = contentPanel;
    this.menuPanel = menuPanel;
    this.totalPanel = totalPanel;

    write();
  }

  public void write() {
    this.setLayout(null);

    JTextField titleBox = new JTextField(20);
    titleBox.setBounds(50, 10, 800, 40);
    this.add(titleBox);

    JComboBox moodComboBox = new JComboBox(mood);
    moodComboBox.setBounds(850, 10, 100, 40);
    this.add(moodComboBox);

    JTextArea contentBox = new JTextArea();
    contentBox.setText("어디서 읽은 글귀인지 적어주세요");
    contentBox.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        contentBox.setText("");
      }
    });
    contentBox.setLineWrap(true);
    contentBox.setBounds(50, 60, 900, 700);
    this.add(contentBox);

    JButton writingButton = new JButton("글귀 작성하기");
    writingButton.addActionListener(event -> {
      String sentence = titleBox.getText();
      String content = contentBox.getText();
      String state = "EXISTENCE";
      String selectedMood = String.valueOf(moodComboBox.getSelectedItem());

      posts.add(new Post(sentence, content, state, selectedMood));

      refreshPanel();

      mainPanel = new MainPanel(posts, mainPanel, contentPanel);
      showContentPanel(mainPanel);
    });

    writingButton.setBounds(850, 800, 100, 40);
    this.add(writingButton);
  }

  private void refreshPanel() {
    this.removeAll();
    this.setVisible(false);
    this.setVisible(true);
  }

  private void showContentPanel(JPanel panel) {
    mainPanel.setOpaque(false);
    contentPanel.removeAll();
    contentPanel.add(panel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
  }
}


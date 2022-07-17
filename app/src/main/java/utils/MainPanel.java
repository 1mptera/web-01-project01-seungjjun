package utils;

import models.Post;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class MainPanel extends JPanel {
  private List<Post> posts;
  private JPanel mainPanel;
  private JPanel contentPanel;

  public MainPanel(List<Post> posts, JPanel mainPanel, JPanel contentPanel) {
    this.posts = posts;
    this.mainPanel = mainPanel;
    this.contentPanel = contentPanel;

    this.setLayout(new GridLayout(0, 1));
    sentencePanel();
  }

  public void sentencePanel() {
    for (Post post : posts) {
      if (!post.state().equals("DELETION")) {
        JLabel sentenceLabel = new JLabel(post.title());
        sentenceLabel.setFont(new Font("Serif", Font.BOLD, 15));
        sentenceLabel.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent e) {
            JFrame writingDetailFrame = new WritingDetailFrame(posts, post, mainPanel, contentPanel);
          }
        });

        this.add(sentenceLabel);
      }
    }
  }
}

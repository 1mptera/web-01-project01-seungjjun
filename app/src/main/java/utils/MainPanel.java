package utils;

import models.Post;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class MainPanel extends JPanel {
  private List<Post> posts;

  public MainPanel(List<Post> posts) {
    this.posts = posts;

    this.setLayout(new GridLayout(0, 1));
    sentencePanel();
  }

  public void sentencePanel() {
    for (Post writing : posts) {
      if (!writing.state().equals("DELETION")) {

        JLabel sentenceLabel = new JLabel(writing.title());
        sentenceLabel.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent e) {
            JFrame writingDetailFrame = new WritingDetailFrame(posts, writing);
          }
        });

        this.add(sentenceLabel);
      }
    }
  }

}

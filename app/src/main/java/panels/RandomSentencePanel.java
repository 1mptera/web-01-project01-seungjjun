package panels;

import models.Post;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Random;

public class RandomSentencePanel {
  private List<Post> posts;

  private JPanel totalPanel;

  public JLabel sentenceLabel;
  public JButton saveButton;

  public void randomSentence(List<Post> posts, String mood, JPanel totalPanel) {
    this.posts = posts;
    this.totalPanel = totalPanel;

    boolean isClickedMoodEqualsRandomMood = true;

    while (isClickedMoodEqualsRandomMood) {
      Random random = new Random();

      String randomPost = String.valueOf(posts.get(random.nextInt(posts.size())));

      String postMood = parsePostMood(randomPost);
      String sentence = parsePostSentence(randomPost);

      if(postMood.equals(mood)) {
        sentenceLabel = new JLabel("<html><body style='text-align:center;'>"
            + sentence
            + "</body></html>");
        sentenceLabel.setBounds(260,300,1000,100);
        sentenceLabel.setFont(new Font("Serif", Font.BOLD, 17));

        totalPanel.add(sentenceLabel);

        saveButton = new JButton("저장하기");
        saveButton.setBounds(880,800,80,30);
        saveButton.addActionListener(event -> {

        });

        totalPanel.add(saveButton);

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
}

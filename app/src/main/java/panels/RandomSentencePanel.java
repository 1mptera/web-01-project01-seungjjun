package panels;

import models.Post;
import models.Storage;
import utils.SentenceLoader;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Random;

public class RandomSentencePanel {
  SentenceLoader sentenceLoader = new SentenceLoader();

  private List<Post> posts;

  private List<Storage> storages;
  private JPanel totalPanel;

  public JLabel sentenceLabel;
  public JButton saveButton;
  private Random random;

  public void randomSentence(
      List<Post> posts,
      List<Storage> storages,
      String mood,
      JPanel totalPanel) {

    random = new Random();

    this.posts = posts;
    this.storages = storages;
    this.totalPanel = totalPanel;

    boolean isClickedMoodEqualsRandomMood = true;

    while (isClickedMoodEqualsRandomMood) {
      String randomPost = String.valueOf(posts.get(random.nextInt(posts.size())));

      String postMood = parsePostMood(randomPost);
      String sentence = parsePostSentence(randomPost);

      if (postMood.equals(mood)) {
        sentenceLabel = new JLabel("<html>"
            + sentence.replaceAll("newLine", "<br/>")
            + "</html>");
        sentenceLabel.setBounds(260, 300, 1000, 100);
        sentenceLabel.setFont(new Font("Serif", Font.BOLD, 17));

        totalPanel.add(sentenceLabel);

        saveButton = new JButton("저장하기");
        saveButton.setBounds(880, 800, 80, 30);

        sentenceLoader.saveSentence(storages, sentence, saveButton, totalPanel);

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

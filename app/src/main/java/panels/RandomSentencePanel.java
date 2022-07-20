package panels;

import models.Post;
import models.Storage;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Random;

public class RandomSentencePanel {
  private List<Post> posts;

  private List<Storage> storages;
  private JPanel totalPanel;

  public JLabel sentenceLabel;
  public JButton saveButton;

  public void randomSentence(
      List<Post> posts,
      List<Storage> storages,
      String mood,
      JPanel totalPanel) {

    this.posts = posts;
    this.storages = storages;
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

        saveSentence(sentence);

        totalPanel.add(saveButton);

        isClickedMoodEqualsRandomMood = false;
      }
    }
  }

  private void saveSentence(String sentence) {
    saveButton.addActionListener(event -> {
      String savingSentence = sentence;
      storages.add(new Storage(savingSentence));

    });
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

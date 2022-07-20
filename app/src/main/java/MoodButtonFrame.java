import models.Post;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

class MoodButtonsPanel extends JPanel{
  private Image img;

  public MoodButtonsPanel(Image img) {
    this.img = img;
    setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
    setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
    setLayout(null);
  }

  public void paintComponent(Graphics g) {
    g.drawImage(img, 0, 0 ,null);
  }
}

public class MoodButtonFrame {
  private JFrame buttonFrame;

  private JPanel moodButtonsPanel;

  private JButton lifeButton;
  private JButton motivationButton;
  private JButton partingButton;
  private JButton hopeButton;

  private Post post;

  public static void main(String[] args) {
    MoodButtonFrame application = new MoodButtonFrame();
    application.run();
  }

  public void run() {
    initFrame();

    setButtonsLayout();

    buttonFrame.setVisible(true);

    lifeButton.addActionListener(event -> {
      showDailySentenceFrame(lifeButton);
    });

    motivationButton.addActionListener(event -> {
      showDailySentenceFrame(motivationButton);
    });
// breakup
    partingButton.addActionListener(event -> {
      showDailySentenceFrame(partingButton);
    });

    hopeButton.addActionListener(event -> {
      showDailySentenceFrame(hopeButton);
    });
  }

  private void showDailySentenceFrame(JButton button) {
    String mood = button.getText();
    try {
      JFrame dailySentence = new DailySentence(mood);

    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public void initFrame() {
    buttonFrame = new JFrame("기분에 맞는 버튼을 선택하세요");
    buttonFrame.setSize(500,500);
    buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void setButtonsLayout() {
    moodButtonsPanel = new MoodButtonsPanel(new ImageIcon("./app/src/main/img/background.jpeg").getImage());

    buttonFrame.add(moodButtonsPanel);

    createLifeButton();
    createMotivationButton();
    createPartingButton();
    createHopeButton();
  }

  private void createLifeButton() {
    lifeButton = new JButton("인생");
    lifeButton.setBounds(160,20,80,50);
    moodButtonsPanel.add(lifeButton);
  }

  private void createMotivationButton() {
    motivationButton = new JButton("동기부여");
    motivationButton.setBounds(290,20,80,50);
    moodButtonsPanel.add(motivationButton);
  }

  private void createPartingButton() {
    partingButton = new JButton("이별");
    partingButton.setBounds(160, 110, 80, 50);
    moodButtonsPanel.add(partingButton);
  }

  private void createHopeButton() {
    hopeButton = new JButton("희망");
    hopeButton.setBounds(290,110,80,50);
    moodButtonsPanel.add(hopeButton);
  }
}

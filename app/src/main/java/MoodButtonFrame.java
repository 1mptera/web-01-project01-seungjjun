import panels.MoodButtonImagePanel;

import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.io.FileNotFoundException;

public class MoodButtonFrame {
  private JFrame buttonFrame;

  private JPanel moodButtonsPanel;

  private JButton lifeButton;
  private JButton motivationButton;
  private JButton breakupButton;
  private JButton hopeButton;

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

    breakupButton.addActionListener(event -> {
      showDailySentenceFrame(breakupButton);
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
    buttonFrame.setSize(500, 500);
    buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void setButtonsLayout() {
    moodButtonsPanel = new MoodButtonImagePanel(
        new ImageIcon("./app/src/main/img/background.jpeg").getImage());

    buttonFrame.add(moodButtonsPanel);

    createLifeButton();
    createMotivationButton();
    createBreakupButton();
    createHopeButton();
  }

  private void createLifeButton() {
    lifeButton = new JButton("인생");
    lifeButton.setBounds(160, 20, 80, 50);
    moodButtonsPanel.add(lifeButton);
  }

  private void createMotivationButton() {
    motivationButton = new JButton("동기부여");
    motivationButton.setBounds(290, 20, 80, 50);
    moodButtonsPanel.add(motivationButton);
  }

  private void createBreakupButton() {
    breakupButton = new JButton("이별");
    breakupButton.setBounds(160, 110, 80, 50);
    moodButtonsPanel.add(breakupButton);
  }

  private void createHopeButton() {
    hopeButton = new JButton("희망");
    hopeButton.setBounds(290, 110, 80, 50);
    moodButtonsPanel.add(hopeButton);
  }
}

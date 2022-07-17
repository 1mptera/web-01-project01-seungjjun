import models.Post;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class MoodButtonFrame {
  private JFrame buttonFrame;

  private GridBagLayout gridBagLayout;
  private GridBagConstraints gridBagConstraints;

  private JPanel moodButtonsPanel;

  private JButton lifeButton;
  private JButton motivationBtuoon;
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

    motivationBtuoon.addActionListener(event -> {
      showDailySentenceFrame(motivationBtuoon);
    });

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
    buttonFrame.setSize(400,300);
    buttonFrame.setLayout(new FlowLayout());
//    buttonFrame.setLocationRelativeTo(null);
    buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void setButtonsLayout() {
//    gridBagLayout = new GridBagLayout();
//    gridBagConstraints = new GridBagConstraints();
//    gridBagConstraints.weightx=1.0;
//    gridBagConstraints.weighty=1.0;

//    moodButtonsPanel.setLayout(gridBagLayout);
//    gridBagConstraints.fill = GridBagConstraints.BOTH;

    moodButtonsPanel = new JPanel();
    buttonFrame.add(moodButtonsPanel);

    createLifeButton();
    createMotivationButton();
    createPartingButton();
    createHopeButton();
  }

  private void createLifeButton() {
//    gridBagConstraints.gridx=0;
//    gridBagConstraints.gridy=0;
//    gridBagConstraints.gridwidth=1;
//    gridBagConstraints.gridheight=1;

    lifeButton = new JButton("인생");
    moodButtonsPanel.add(lifeButton);
  }

  private void createMotivationButton() {
//    gridBagConstraints.gridx=0;
//    gridBagConstraints.gridy=1;
//    gridBagConstraints.gridwidth=1;
//    gridBagConstraints.gridheight=1;

    motivationBtuoon = new JButton("동기부여");
    moodButtonsPanel.add(motivationBtuoon);
  }

  private void createPartingButton() {
//    gridBagConstraints.gridx=1;
//    gridBagConstraints.gridy=0;
//    gridBagConstraints.gridwidth=1;
//    gridBagConstraints.gridheight=1;

    partingButton = new JButton("이별");
    moodButtonsPanel.add(partingButton);
  }

  private void createHopeButton() {
//    gridBagConstraints.gridx=1;
//    gridBagConstraints.gridy=1;
//    gridBagConstraints.gridwidth=1;
//    gridBagConstraints.gridheight=1;

    hopeButton = new JButton("희망");
    moodButtonsPanel.add(hopeButton);
  }
}

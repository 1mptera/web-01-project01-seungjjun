import utils.MainPanel;
import utils.WritingFrame;

import javax.swing.*;
import java.awt.*;

public class DailySentence {
  private JFrame frame;

  private JPanel contentPanel;

  public static void main(String[] args) {
    DailySentence application = new DailySentence();
    application.run();
  }

  public void run() {
    initFrame();
    initMenuButtons();
    initContentPanel();

    frame.setVisible(true);
  }

  public void initFrame() {
    frame = new JFrame("Daily Sentence");
    frame.setSize(800,800);
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
      JPanel mainPanel = new MainPanel();
      showContentPanel(mainPanel);
    });

    return mainButton;
  }

  private JButton createWritingButton() {
    JButton writingButton = new JButton("글귀 작성하기");
    writingButton.addActionListener(event -> {
      JFrame writingFrame = new WritingFrame();
//      showContentPanel(writingFrame
//     );
    });

    return writingButton;
  }

  private void showContentPanel(JPanel panel) {
    contentPanel.removeAll();
    contentPanel.add(panel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
    frame.setVisible(true);
  }
}

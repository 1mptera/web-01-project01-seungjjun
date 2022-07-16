package utils;

import models.Writing;

import javax.swing.*;
import java.util.List;

public class WritingFrame extends JPanel {
  private List<Writing> writings;

  private JPanel mainPanel;
  private JPanel contentPanel;

  public WritingFrame(List<Writing> writings,
                      JPanel mainPanel,
                      JPanel contentPanel) {

    this.writings = writings;
    this.mainPanel = mainPanel;
    this.contentPanel = contentPanel;

    write();
  }

  public void write() {
    this.setLayout(null);

    JTextField titleBox = new JTextField(20);
    titleBox.setBounds(50, 10, 700, 40);
    this.add(titleBox);

    JTextArea contentBox = new JTextArea();
    contentBox.setBounds(50, 60, 700, 600);
    this.add(contentBox);

    JButton writingButton = new JButton("글귀 작성하기");
    writingButton.addActionListener(event -> {
      String sentence = titleBox.getText();
      String content = contentBox.getText();

      writings.add(new Writing(sentence, content));

      refreshPanel();

      mainPanel = new MainPanel(writings);

      showContentPanel(mainPanel);
    });

    writingButton.setBounds(650, 680, 100, 40);
    this.add(writingButton);
  }

  private void refreshPanel() {
    this.removeAll();
    this.setVisible(false);
    this.setVisible(true);
  }

  private void showContentPanel(JPanel panel) {
    contentPanel.removeAll();
    contentPanel.add(panel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
  }
}

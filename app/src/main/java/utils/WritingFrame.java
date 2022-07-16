package utils;

import javax.swing.*;

public class WritingFrame extends JFrame {
  private JFrame writingFrame;

  public WritingFrame() {
    writingFrame = new JFrame("Daily Sentence");
    writingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    writingFrame.setSize(800,800);

    write();

    writingFrame.setVisible(true);
  }

  public void write() {
    JPanel writingPanel = new JPanel();
    writingPanel.setLayout(null);

    JTextField titleBox = new JTextField(20);
    titleBox.setBounds(50,10, 700, 40);
    writingPanel.add(titleBox);

    JTextArea contentBox = new JTextArea();
    contentBox.setBounds(50,60,700, 600);
    writingPanel.add(contentBox);

    JButton writingButton = new JButton("글귀 작성하기");
    writingButton.addActionListener(event -> {

    });
    writingButton.setBounds(650,700,100,40);
    writingPanel.add(writingButton);

    writingFrame.add(writingPanel);

    writingFrame.setVisible(true);
  }
}

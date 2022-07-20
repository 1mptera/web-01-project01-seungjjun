package frames;

import models.Post;
import panels.MainPanel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class WritingFrame extends JFrame {
  private Post post;

  private List<Post> posts;

  private JFrame writeFrame;

  private JPanel writePanel;
  private JPanel mainPanel;
  private JPanel contentPanel;
  private JPanel menuPanel;

  private String[] mood = {"인생", "동기부여", "이별", "희망"};

  public WritingFrame(List<Post> posts,
                      JPanel mainPanel,
                      JPanel contentPanel,
                      JPanel menuPanel) {

    this.posts = posts;
    this.mainPanel = mainPanel;
    this.contentPanel = contentPanel;
    this.menuPanel = menuPanel;

    initFrame();

    write();

    writeFrame.setVisible(true);
  }

  private void initFrame() {
    writeFrame = new JFrame();
    writeFrame.setSize(1000, 1000);
    writeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }

  public void write() {
    writePanel = new JPanel();
    writePanel.setLayout(null);

    JTextField titleBox = new JTextField(20);
    titleBox.setBounds(50, 10, 800, 40);
    writePanel.add(titleBox);

    JComboBox moodComboBox = new JComboBox(mood);
    moodComboBox.setBounds(850, 10, 100, 40);
    writePanel.add(moodComboBox);

    JTextArea contentBox = new JTextArea();
    contentBox.setText("어디서 읽은 글귀인지 적어주세요");
    contentBox.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        contentBox.setText("");
      }
    });
    contentBox.setLineWrap(true);
    contentBox.setBounds(50, 60, 900, 700);
    writePanel.add(contentBox);

    JButton writingButton = new JButton("글귀 작성하기");
    writingButton.addActionListener(event -> {
      String sentence = titleBox.getText();
      String content = contentBox.getText();
      String state = "EXISTENCE";
      String selectedMood = String.valueOf(moodComboBox.getSelectedItem());

      posts.add(new Post(sentence, content, state, selectedMood));

      writeFrame.setVisible(false);

      mainPanel = new MainPanel(posts, mainPanel, contentPanel);
      showContentPanel(mainPanel);
    });

    writingButton.setBounds(850, 800, 100, 40);
    writePanel.add(writingButton);

    writeFrame.add(writePanel);
  }

  private void showContentPanel(JPanel panel) {
    mainPanel.setOpaque(false);
    contentPanel.removeAll();
    contentPanel.add(panel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
  }
}


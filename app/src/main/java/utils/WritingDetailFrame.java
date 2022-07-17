package utils;

import models.Post;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class WritingDetailFrame extends JFrame {
  private List<Post> posts;
  private Post post;

  private JFrame detailFrame;
  private JPanel detailPanel;

  private String[] mood = {"인생", "동기부여", "이별", "희망"};

  public WritingDetailFrame(List<Post> posts, Post post) {
    this.posts = posts;
    this.post = post;

    detailFrame = new JFrame();
    detailFrame.setSize(800, 800);
    detailFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    loadContent();

    detailFrame.setVisible(true);
  }

  private void loadContent() {
    detailPanel = new JPanel();
    detailPanel.setLayout(null);

    detailPanel.add(createContent());
    detailPanel.add(createDeleteButton());
    detailPanel.add(cteateModifyButton());

    detailFrame.add(detailPanel);
  }

  private JLabel createContent() {
    String content = post.content();
    JLabel label = new JLabel(content);
    label.setBounds(10, 10, 700, 600);
    return label;
  }

  private JButton cteateModifyButton() {
    JButton modifyButton = new JButton("수정하기");
    modifyButton.setBounds(530, 700, 100, 40);
    modifyButton.addActionListener(event -> {
      detailPanel.removeAll();

      JButton internalModifiyButton = new JButton("수정하기");
      internalModifiyButton.setBounds(650, 700, 100, 40);
      detailPanel.add(internalModifiyButton);

      JTextField titleBox = new JTextField(20);
      titleBox.setBounds(50, 10, 600, 40);
      titleBox.setText(post.title());
      detailPanel.add(titleBox);

      JComboBox moodComboBox = new JComboBox(mood);
      moodComboBox.setBounds(650, 10, 100, 40);
      detailPanel.add(moodComboBox);

      JTextArea contentBox = new JTextArea();
      contentBox.setBounds(50, 60, 700, 600);
      contentBox.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
          contentBox.setText("");
        }
      });
      contentBox.setText(post.content());
      detailPanel.add(contentBox);

      internalModifiyButton.addActionListener(event2 -> {
        post.modifyTitle(titleBox.getText());
        post.modifyContent(contentBox.getText());
        post.modifyMood(String.valueOf(moodComboBox.getSelectedItem()));

        detailFrame.setVisible(false);
      });

      detailPanel.setVisible(false);
      detailPanel.setVisible(true);
    });
    return modifyButton;
  }

  private JButton createDeleteButton() {
    JButton deleteButton = new JButton("삭제하기");
    deleteButton.setBounds(650, 700, 100, 40);
    deleteButton.addActionListener(event -> {
      post.deletion();
      detailFrame.setVisible(false);
    });
    return deleteButton;
  }
}

package frames;

import models.Post;
import panels.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class WritingDetailFrame extends JFrame {
  private List<Post> posts;
  private Post post;
  private JPanel mainPanel;

  private JFrame detailFrame;
  private JPanel detailPanel;

  private String[] mood = {"인생", "동기부여", "이별", "희망"};
  private JPanel contentPanel;

  public WritingDetailFrame(List<Post> posts, Post post, JPanel mainPanel, JPanel contentPanel) {
    this.posts = posts;
    this.post = post;
    this.mainPanel = mainPanel;
    this.contentPanel = contentPanel;

    detailFrame = new JFrame();
    detailFrame.setSize(1000, 1000);
    detailFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    loadContent();

    detailFrame.setVisible(true);
  }

  private void loadContent() {
    detailPanel = new JPanel();
    detailPanel.setLayout(null);

    detailPanel.add(createContent());
    detailPanel.add(createMood());
    detailPanel.add(createDeleteButton());
    detailPanel.add(createModifyButton());
    detailPanel.add(createGoBackButton());

    detailFrame.add(detailPanel);
  }

  private JLabel createContent() {
    JLabel informationLabel = new JLabel("글귀에 대한 정보(출처)에 대한 상세 페이지 입니다." +
        " (어디서 읽었는지, 누가 말 했는지) ");
    informationLabel.setFont(new Font("Serif", Font.BOLD, 18));
    informationLabel.setBounds(10,20, 800,20);
    detailPanel.add(informationLabel);

    JLabel titleLabel = new JLabel("제목: " + post.title());
    titleLabel.setFont(new Font("Serif", Font.BOLD, 17));
    titleLabel.setBounds(10,70,800,20);
    detailPanel.add(titleLabel);


    JLabel contentLabel = new JLabel();
    contentLabel.setText("<html>정보 : "
        + post.content().replaceAll("newLine", "<br/>") + "</html>");
    contentLabel.setFont(new Font("Serif", Font.BOLD, 16));
    contentLabel.setBounds(10, 80, 1000, 100);
    return contentLabel;
  }

  private JLabel createMood() {
    String mood = post.mood();
    JLabel moodLabel = new JLabel("카테고리: " + mood);
    moodLabel.setFont(new Font("Serif", Font.BOLD, 15));
    moodLabel.setBounds(880,20,100,30);
    return moodLabel;
  }

  private JButton createModifyButton() {
    JButton modifyButton = new JButton("수정하기");
    modifyButton.setBounds(730, 800, 100, 40);
    modifyButton.addActionListener(event -> {
      detailPanel.removeAll();

      JButton internalModifiyButton = new JButton("수정하기");
      internalModifiyButton.setBounds(850, 800, 100, 40);
      detailPanel.add(internalModifiyButton);

      JTextField titleBox = new JTextField(20);
      titleBox.setBounds(50, 10, 800, 40);
      titleBox.setText(post.title());
      detailPanel.add(titleBox);

      JComboBox moodComboBox = new JComboBox(mood);
      moodComboBox.setBounds(850, 10, 100, 40);
      detailPanel.add(moodComboBox);

      JTextArea contentBox = new JTextArea();
      contentBox.setBounds(50, 60, 900, 700);
      contentBox.setText(post.content());
      detailPanel.add(contentBox);

      internalModifiyButton.addActionListener(event2 -> {
        post.modifyTitle(titleBox.getText());
        post.modifyContent(contentBox.getText());
        post.modifyMood(String.valueOf(moodComboBox.getSelectedItem()));

        detailFrame.setVisible(false);

        mainPanel = new MainPanel(posts, mainPanel, contentPanel);
        showContentPanel(mainPanel);
      });

      detailPanel.setVisible(false);
      detailPanel.setVisible(true);
    });
    return modifyButton;
  }

  private JButton createDeleteButton() {
    JButton deleteButton = new JButton("삭제하기");
    deleteButton.setBounds(850, 800, 100, 40);
    deleteButton.addActionListener(event -> {
      post.deletion();
      detailFrame.setVisible(false);

      mainPanel = new MainPanel(posts, mainPanel, contentPanel);
      showContentPanel(mainPanel);
    });
    return deleteButton;
  }

  private JButton createGoBackButton() {
    JButton goBackButton = new JButton("뒤로가기");
    goBackButton.setBounds(20,800,100,40);
    goBackButton.addActionListener(event -> {
      detailFrame.setVisible(false);
      mainPanel = new MainPanel(posts, mainPanel, contentPanel);
      showContentPanel(mainPanel);
    });
    return goBackButton;
  }

  private void showContentPanel(JPanel mainPanel) {
    mainPanel.setOpaque(false);
    contentPanel.removeAll();
    contentPanel.add(mainPanel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
  }
}

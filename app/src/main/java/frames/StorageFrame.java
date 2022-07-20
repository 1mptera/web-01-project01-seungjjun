package frames;

import javax.swing.*;
import java.awt.*;

public class StorageFrame extends JFrame {
  private JFrame frame;

  public StorageFrame() {
    initFrame();
    intiMenuBar();

    frame.setVisible(true);
  }

  private void initFrame() {
    frame = new JFrame("글귀 보관함");
    frame.setSize(400, 300);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }

  private void intiMenuBar() {
    JPanel menuPanel = new JPanel();
    menuPanel.setBackground(Color.getHSBColor(327, 22, 67));

    menuPanel.add(titleLabel());

    frame.add(menuPanel, BorderLayout.PAGE_START);
  }

  private JLabel titleLabel() {
    JLabel titleLabel = new JLabel("글귀 보관함");

    return titleLabel;
  }
}

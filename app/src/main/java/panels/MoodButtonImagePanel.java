package panels;

import javax.swing.*;
import java.awt.*;

public class MoodButtonImagePanel extends JPanel {
  private Image img;

  public MoodButtonImagePanel(Image img) {
    this.img = img;
    setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
    setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
    setLayout(null);
  }

  public void paintComponent(Graphics g) {
    g.drawImage(img, 0, 0, null);
  }
}

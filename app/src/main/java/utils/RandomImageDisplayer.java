package utils;

import panels.ImagePanel;

import javax.swing.*;
import java.util.Random;

public class RandomImageDisplayer {
  private JPanel totalPanel;

  private Random random;

  public JPanel randomImageDisplay(JPanel totalPanel) {
    random = new Random();

    this.totalPanel = totalPanel;

    ImageIcon[] imgaes = {
        new ImageIcon("./app/src/main/img/background1.jpeg"),
        new ImageIcon("./app/src/main/img/background2.jpeg"),
        new ImageIcon("./app/src/main/img/background3.jpeg"),
        new ImageIcon("./app/src/main/img/background4.jpeg"),
        new ImageIcon("./app/src/main/img/background5.jpeg")
    };

    totalPanel = new ImagePanel(new ImageIcon(String.valueOf(
        imgaes[random.nextInt(imgaes.length)])).getImage());

    return totalPanel;
  }
}

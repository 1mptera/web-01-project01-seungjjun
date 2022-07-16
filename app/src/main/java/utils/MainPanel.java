package utils;

import models.Writing;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainPanel extends JPanel {
  private List<Writing> writings;

  public MainPanel(List<Writing> writings) {
    this.writings = writings;
    this.setLayout(new GridLayout(0, 1));

    sentencePanel();
  }

  public void sentencePanel() {
    for (Writing writing : writings) {
      if (!writing.state().equals("DELETION")) {
        JLabel sentenceLabel = new JLabel(writing.text());
        this.add(sentenceLabel);
      }
    }
  }
}

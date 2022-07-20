package frames;

import models.Post;
import models.Storage;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StorageFrame extends JFrame {
  private JFrame frame;
  private List<Storage> storages;

  public StorageFrame(List<Storage> storages) {
    this.storages = storages;

    initFrame();
    intiMenuBarPanel();
    initContentPanel();

    frame.setVisible(true);
  }

  private void initFrame() {
    frame = new JFrame("글귀 보관함");
    frame.setSize(500, 600);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }

  private void intiMenuBarPanel() {
    JPanel menuPanel = new JPanel();
    menuPanel.setBackground(Color.getHSBColor(327, 22, 67));

    menuPanel.add(titleLabel());

    frame.add(menuPanel, BorderLayout.PAGE_START);
  }

  private void initContentPanel() {
    JPanel contentPanel = new JPanel();
    contentPanel.setLayout(new GridLayout(0,1));

    for (Storage storage : storages) {
      if (!storage.state().equals("DELETION")) {
        JLabel sentenceLabel = new JLabel(storage.sentence());

        sentenceLabel.setFont(new Font("Serif", Font.BOLD, 15));

        contentPanel.add(sentenceLabel);
      }
    }

    frame.add(contentPanel);
  }

  private JLabel titleLabel() {
    JLabel titleLabel = new JLabel("글귀 보관함");

    return titleLabel;
  }
}

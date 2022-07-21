package utils;

import models.Storage;

import javax.swing.*;
import java.util.List;

public class SentenceLoader {
  public List<Storage> storages;

  private String savingSentence;

  private boolean isSaved = true;

  public void saveSentence(List<Storage> storages,
                           String sentence,
                           JButton saveButton,
                           JPanel totalPanel) {

    this.storages = storages;

    saveButton.addActionListener(event -> {
      savingSentence = sentence;

      repetitionVerifier();

      if (!isSaved) {
        JOptionPane.showMessageDialog(totalPanel,
            "이미 저장소에 저장되어 있습니다!",
            "저장 실패",
            JOptionPane.WARNING_MESSAGE);
      }

      if (isSaved) {
        storages.add(new Storage(savingSentence));
        JOptionPane.showMessageDialog(
            totalPanel,
            "저장되었습니다!",
            "저장 성공",
            JOptionPane.INFORMATION_MESSAGE);
      }
    });
  }

  private void repetitionVerifier() {
    for (int i = 0; i < storages.size(); i += 1) {
      if (savingSentence.equals(storages.get(i).toString())) {
        isSaved = false;
      }
    }
  }
}

package models;

public class Storage {
  private static final String EXISTENCE = "EXISTENCE";
  private static final String DELETION = "DELETION";

  private String sentence;
  private String state;

  public Storage(String sentence) {
    this.sentence = sentence;
    this.state = Storage.EXISTENCE;
  }

  public String toCsvRow() {
    return sentence + "," + state;
  }

  public String sentence() {
    return sentence;
  }

  public String state() {
    return state;
  }

  @Override
  public String toString() {
    return sentence;
  }
}

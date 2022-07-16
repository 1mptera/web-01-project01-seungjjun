package models;

public class Writing {
  private static final String EXISTENCE = "EXISTENCE";
  private static final String DELETION = "DELETION";

  private String state;
  private String text;
  private String content;

  public Writing(String text, String content) {
    this.text = text;
    this.content = content;
    this.state = Writing.EXISTENCE;
  }

  public String content() {
    return content;
  }

  public String state() {
    return state;
  }

  public String text() {
    return text;
  }

  public void deletion() {
    this.state = "DELETION";
  }
}

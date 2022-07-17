package models;

public class Post {
  private static final String EXISTENCE = "EXISTENCE";
  private static final String DELETION = "DELETION";

  private String state;
  private String title;
  private String content;

  public Post(String title, String content) {
    this.title = title;
    this.content = content;
    this.state = Post.EXISTENCE;
  }

  public String state() {
    return state;
  }

  public String title() {
    return title;
  }

  public String content() {
    return content;
  }

  public void deletion() {
    this.state = DELETION;
  }

  public void modifyTitle(String title) {
    this.title = title;
  }

  public void modifyContent(String content) {
    this.content = content;
  }
}

package models;

public class Post {
  private static final String EXISTENCE = "EXISTENCE";
  private static final String DELETION = "DELETION";

  private String mood;
  private String state;
  private String title;
  private String content;
  private int like;

  public Post(String title, String content) {
    this.title = title;
    this.content = content;
    this.state = Post.EXISTENCE;
    this.like = 0;
  }

  public Post(String title, String content, String state, String mood) {
    this.title = title;
    this.content = content;
    this.state = state;
    this.mood = mood;
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

  public String mood() {
    return mood;
  }

  public void deletion() {
    this.state = Post.DELETION;
  }

  public void modifyTitle(String title) {
    this.title = title;
  }

  public void modifyContent(String content) {
    this.content = content;
  }

  public void modifyMood(String mood) {
    this.mood = mood;
  }

  public String toCsvRow() {
    return title + "," + content + "," + state + "," + mood;
  }

  @Override
  public String toString() {
    return title + "," + content + "," + state + "," + mood;
  }
}

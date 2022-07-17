package models;

public class Book {

  private String title;
  private String summary;

  public Book(String title, String summary) {
    this.title = title;
    this.summary = summary;
  }

  public String title() {
    return title;
  }

  public String summary() {
    return summary;
  }
}

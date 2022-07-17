package models;

public class Book {
  private static final String EXISTENCE = "EXISTENCE";
  private static final String DELETION = "DELETION";

  private String title;
  private String summary;
  private String state;
  private String starRating;

  public Book(String title, String summary) {
    this.title = title;
    this.summary = summary;
    this.state = Book.EXISTENCE;
  }

  public Book(String title, String summary, String state, String starRating) {
    this.title = title;
    this.summary = summary;
    this.state = state;
    this.starRating = starRating;
  }

  public String title() {
    return title;
  }

  public String summary() {
    return summary;
  }

  public String toCsvRow() {
    return title + "`" + summary + "`" + state + "`" + starRating;
  }
}

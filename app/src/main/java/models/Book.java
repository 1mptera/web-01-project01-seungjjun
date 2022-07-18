package models;

public class Book {
  private static final String EXISTENCE = "EXISTENCE";
  private static final String DELETION = "DELETION";

  private String title;
  private String summary;
  private String state;
  private String starRating;
  private double star;

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

  public String starRating() {
    return starRating;
  }

  public String summary() {
    return summary;
  }

  public String toCsvRow() {
    return title + "`" + summary + "`" + state + "`" + starRating;
  }

  public double star() {
    return star;
  }

  public void conversionStar(String star) {
    switch (star) {
      case "⭐" -> this.star += 1;
      case "⭐⭐" -> this.star += 2;
      case "⭐⭐⭐" -> this.star += 3;
      case "⭐⭐⭐⭐" -> this.star += 4;
      case "⭐⭐⭐⭐⭐" -> this.star += 5;
      default -> this.star += 0;
    }
  }

  public void modifyStarRating(String star) {
    this.starRating = star;
  }
}

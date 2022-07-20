package models;

public class Book {
  private static final String EXISTENCE = "EXISTENCE";
  private static final String DELETION = "DELETION";

  private String title;
  private String summary;
  private String state;
  private String clickedNumber;
  private String accumulator;
  private String starRating;
  private double star;

  public Book(String title, String summary) {
    this.title = title;
    this.summary = summary;
    this.state = Book.EXISTENCE;
    this.starRating = "0.0";
    this.clickedNumber = "0";
    this.accumulator = "0.0";
  }

  public Book(String starRating,
              String title,
              String summary,
              String state,
              String clickedNumber,
              String accumulator) {
    this.starRating = starRating;
    this.title = title;
    this.summary = summary;
    this.state = state;
    this.clickedNumber = clickedNumber;
    this.accumulator = accumulator;
  }

  public Book() {
    this.starRating = "0.0";
    this.clickedNumber = "0";
    this.accumulator = "0.0";
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

  public String state() {
    return state;
  }

  public void deletion() {
    this.state = Book.DELETION;
  }

  public String toCsvRow() {
    return starRating + "`" +
        title + "`" +
        summary + "`" +
        state + "`" +
        clickedNumber + "`" +
        accumulator;
  }

  public double star() {
    return star;
  }

  public void conversionStar(String star) {
    switch (star) {
      case "⭐" -> this.star = 1;
      case "⭐⭐" -> this.star = 2;
      case "⭐⭐⭐" -> this.star = 3;
      case "⭐⭐⭐⭐" -> this.star = 4;
      case "⭐⭐⭐⭐⭐" -> this.star = 5;
      default -> this.star += 0;
    }
  }

  public void modifyStarRating(String star) {
    this.starRating = star;
  }

  public String clickedNumber() {
    return clickedNumber;
  }

  public void plusClickedNumber(String count) {
    clickedNumber = count;
  }

  public String getAccumulator() {
    return accumulator;
  }

  public void accumulator(String totalStar) {
    accumulator = totalStar;
  }

  @Override
  public String toString() {
    return starRating +  title +  summary + state + clickedNumber;
  }
}

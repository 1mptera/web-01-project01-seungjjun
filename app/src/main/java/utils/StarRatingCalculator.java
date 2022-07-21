package utils;

import models.Book;

import javax.swing.*;

public class StarRatingCalculator {
  private Book book;

  private String totalStar;
  private String starRating;

  public void calculateStarRating(Book book, JComboBox starRatingComboBox) {
    this.book = book;

    String count = String.valueOf(Integer.parseInt(book.clickedNumber()) + 1);
    book.plusClickedNumber(count);

    book.conversionStar(String.valueOf(starRatingComboBox.getSelectedItem()));

    totalStar = sumTotalStarRating(book);
    starRating = computeAverageStarRating(count);

    book.accumulator(totalStar);
    book.modifyStarRating(starRating);
  }

  public String sumTotalStarRating(Book book) {
    totalStar = String.valueOf(
        Double.parseDouble(book.getAccumulator()) + book.star());

    return totalStar;
  }

  public String computeAverageStarRating(String count) {
    starRating = String.valueOf(
        String.format("%.1f", Double.parseDouble(totalStar) / Double.parseDouble(count)));

    return starRating;
  }
}

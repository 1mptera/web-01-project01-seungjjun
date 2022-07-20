package utils;

import models.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StarRatingCalculatorTest {
  @Test
  void calculateStarRating() {
    StarRatingCalculator starRatingCalculator = new StarRatingCalculator();

    assertEquals("15.0", starRatingCalculator.sumTotalStarRating(new Book(
        "5.0",
        "테스트",
        "테스트",
        "EXISTENCE",
        "3",
        "15.0")));

    assertEquals("3.0", starRatingCalculator.computeAverageStarRating("5"));
  }
}

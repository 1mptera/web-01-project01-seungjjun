package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
  @Test
  void creation() {
    Book book = new Book("아몬드",
        "공감 불능 사회, 차가움을 녹이는 아몬드 “고통과 공감의 능력을 깨우치게 할 강력한 소설”");

    assertEquals("아몬드", book.title());
    assertEquals("공감 불능 사회, 차가움을 녹이는 아몬드 “고통과 공감의 능력을 깨우치게 할 강력한 소설”",
        book.summary());
  }

  @Test
  void toCsvROw() {
    Book book = new Book(
        "아몬드",
        "공감 불능 사회, 차가움을 녹이는 아몬드 “고통과 공감의 능력을 깨우치게 할 강력한 소설”",
        "EXISTENCE",
        "4.7",
        "0",
        "0.0");

    assertEquals("아몬드`" +
            "공감 불능 사회, 차가움을 녹이는 아몬드 “고통과 공감의 능력을 깨우치게 할 강력한 소설”`" +
            "EXISTENCE`" +
            "4.7`" +
            "0`" +
            "0.0",
        book.toCsvRow());
  }

  @Test
  void computeStar() {
    Book book = new Book("아몬드",
        "공감 불능 사회, 차가움을 녹이는 아몬드 “고통과 공감의 능력을 깨우치게 할 강력한 소설”",
        "EXISTENCE",
        "4.7",
        "0",
        "0.0");

    book.conversionStar("⭐");
    assertEquals(1, book.star());
  }

  @Test
  void modifyStarRating() {
    Book book = new Book("4.7",
        "아몬드",
        "공감 불능 사회, 차가움을 녹이는 아몬드 “고통과 공감의 능력을 깨우치게 할 강력한 소설”",
        "EXISTENCE",
        "0",
        "0.0");

    assertEquals("4.7", book.starRating());

    book.conversionStar("⭐⭐");

    book.modifyStarRating(String.valueOf(book.star()));
    assertEquals("2.0", book.starRating());

    book.conversionStar("⭐⭐⭐");
    book.modifyStarRating(String.valueOf(book.star()));
    assertEquals("3.0", book.starRating());
  }

  @Test
  void accumulator() {
    Book book = new Book("아몬드","아몬드 내용");

    book.accumulator("4.0");

    assertEquals("4.0", book.getAccumulator());
  }
}

package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
  @Test
  void creation(){
    Book book = new Book("아몬드",
        "공감 불능 사회, 차가움을 녹이는 아몬드 “고통과 공감의 능력을 깨우치게 할 강력한 소설”");

    assertEquals("아몬드", book.title());
    assertEquals("공감 불능 사회, 차가움을 녹이는 아몬드 “고통과 공감의 능력을 깨우치게 할 강력한 소설”",
        book.summary());
  }
}

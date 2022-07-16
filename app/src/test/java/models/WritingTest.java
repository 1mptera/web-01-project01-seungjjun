package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WritingTest {
  @Test
  void creation() {
    Writing writing = new Writing("젊은이여 그 길은 너의 것이다.",
        "2022년 6월 고3 모의고사 필적 확인란 문구");

    assertEquals("젊은이여 그 길은 너의 것이다.", writing.text());
    assertEquals("2022년 6월 고3 모의고사 필적 확인란 문구", writing.content());
  }


  @Test
  void deletion() {
    Writing writing = new Writing("도망쳐서 도착한 곳에 낙원은 없다.",
        "베르세르크 중 한 구절");
    writing.deletion();

    assertEquals("DELETION", writing.state());
  }
}

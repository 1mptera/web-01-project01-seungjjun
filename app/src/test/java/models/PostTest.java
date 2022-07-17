package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {
  @Test
  void creation() {
    Post post = new Post("젊은이여 그 길은 너의 것이다.",
        "2022년 6월 고3 모의고사 필적 확인란 문구");

    assertEquals("젊은이여 그 길은 너의 것이다.", post.title());
    assertEquals("2022년 6월 고3 모의고사 필적 확인란 문구", post.content());
  }


  @Test
  void deletion() {
    Post post = new Post("도망쳐서 도착한 곳에 낙원은 없다.",
        "베르세르크 중 한 구절");
    post.deletion();

    assertEquals("DELETION", post.state());
  }

  @Test
  void modify() {
    Post post = new Post("6개월 투자가 이후 60년을 결정합니다.", "홀맨님 왈");

    post.modifyTitle("지금 6개월 놀면 이후 60년 동안 고통을 만들어 낼 수도 있습니다");
    post.modifyContent("메가테라 디스코드 공지 홀맨님이 남겨주신 코멘트 (6/18)");

    assertEquals("지금 6개월 놀면 이후 60년 동안 고통을 만들어 낼 수도 있습니다", post.title());
    assertEquals("메가테라 디스코드 공지 홀맨님이 남겨주신 코멘트 (6/18)", post.content());
  }
}

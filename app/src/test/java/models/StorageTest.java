package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StorageTest {
  @Test
  void creation() {
    Storage storage = new Storage("행복을 얻기란 그리 어렵지 않다.");

    assertEquals("행복을 얻기란 그리 어렵지 않다.", storage.sentence());
    assertEquals("EXISTENCE", storage.state());
  }

  @Test
  void toCsvRow() {
    Storage storage = new Storage("테스트");

    assertEquals("테스트,EXISTENCE",storage.toCsvRow());
  }
}

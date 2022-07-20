package utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DescendingSortTest {
  private void assertArrayEquals(String[] strings, List<String> stringBooks) {
  }

  @Test
  void descending() {
    DescendingSort descendingSort = new DescendingSort();

    List<String> stringBooks = new ArrayList<>(Arrays.asList("3","5","9","4"));

    descendingSort.descendingSort(stringBooks);

    assertArrayEquals(new String[]{"9","5","4","3"}, stringBooks);
  }
}

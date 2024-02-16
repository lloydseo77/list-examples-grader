import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeEmptyList() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList();
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "b", "c");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeUnsortedList() {
    List<String> left = Arrays.asList("a", "c", "b");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertNotEquals(expected, merged);
  }

  @Test(timeout = 500) 
	public void testFilter() {
        StringChecker testChecker = new IsMoon();

        List<String> list = new ArrayList();
        list.add("sun");
        list.add("moon");
        list.add("earth");
        list.add("moon");

        List<String> expected = new ArrayList();
        expected.add("moon");
        expected.add("moon");

        assertEquals(expected, ListExamples.filter(list, testChecker));
	}
}

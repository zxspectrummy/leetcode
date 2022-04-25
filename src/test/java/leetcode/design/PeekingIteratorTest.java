package leetcode.design;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PeekingIteratorTest {
    @Test
    public void test() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        PeekingIterator iterator = new PeekingIterator(list.iterator());
        assertEquals(iterator.next(), 1);
        assertEquals(iterator.peek(), 2);
        assertEquals(iterator.next(), 2);
        assertEquals(iterator.next(), 3);
        assertFalse(iterator.hasNext());
    }
}

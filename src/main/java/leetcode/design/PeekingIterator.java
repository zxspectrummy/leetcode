package leetcode.design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class PeekingIterator implements Iterator<Integer> {
    List<Integer> list;
    int pos;

    public PeekingIterator(Iterator<Integer> iterator) {
        pos = 0;
        list = new ArrayList<>();
        iterator.forEachRemaining(list::add);
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return list.get(pos);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return list.get(pos++);
    }

    @Override
    public boolean hasNext() {
        return pos < list.size();
    }
}
package leetcode.heap;

import java.util.Iterator;
import java.util.PriorityQueue;

public class KthLargestStructure {
    PriorityQueue<Integer> queue;
    int k;

    public KthLargestStructure(int k, int[] nums) {
        this.queue = new PriorityQueue<>();
        this.k = k;
        for (int i=0;i<nums.length;i++) {
            this.add(nums[i]);
        }
    }

    public int add(int val) {
        if (queue.size()<k) {
            queue.add(val);
        } else if (val>queue.peek()) {
            queue.remove();
            queue.add(val);

        }
        return queue.peek();
    }
}



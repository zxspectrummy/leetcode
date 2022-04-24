package leetcode.heap;

import java.util.*;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.merge(num, 1, Integer::sum);
        }
        return frequencyMap.entrySet().stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .limit(k)
            .mapToInt(Map.Entry::getKey).toArray();
    }

    public int[] topKFrequentHeap(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.merge(n, 1, Integer::sum);
        }
        Queue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(count::get));
        for (int n : count.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }
        int[] topK= heap.stream().mapToInt(Integer::intValue).toArray();
        return topK;
    }

    public static void main(String[] args) {
        new TopKFrequent().run();
    }

    private void run() {
        int[] nums = new int[]{1, 2, 3, 4, 2, 2, 2, 5, 5, 5, 5, 2, 2, 4, 4,};
        System.out.println(topKFrequentHeap(nums, 3));
    }
}

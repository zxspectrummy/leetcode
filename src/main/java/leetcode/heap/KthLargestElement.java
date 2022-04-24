package leetcode.heap;

import java.util.PriorityQueue;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        if (k<0 ||k>nums.length)
            throw new IllegalArgumentException();
        PriorityQueue<Integer> largestK = new PriorityQueue<Integer>(k);
        for (int i = 0; i < Math.min(nums.length,k); i++) {
            largestK.add(nums[i]);
        }
        for (int j=k;j<nums.length;j++) {
            if (nums[j]>largestK.peek()) {
                largestK.remove();
                largestK.add(nums[j]);
            }
        }

        return largestK.peek();
    }

    public static void main(String[] args) {
        new KthLargestElement().run();
    }

    private void run() {
        int[] nums = new int[]{-10,1,3,1,4,10,3,9,4,5,1};
        System.out.println(findKthLargest(nums,7));
    }
}

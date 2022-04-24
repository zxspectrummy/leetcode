package leetcode.heap;

import java.util.Arrays;
import java.util.stream.Collectors;

public class NextPermutation {
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void nextPermutation(int[] nums) {
        if (nums.length < 2)
            return;
        if (nums.length == 2) {
            swap(nums, 0, 1);
            return;
        }
        int i = nums.length - 1;
        while (i > 1 && nums[i] < nums[i - 1])
            i--;
        if (nums[i] < nums[i - 1]) {
            Arrays.sort(nums);
            return;
        }
        for (int j = i; j < nums.length; j++) {
            if (nums[j]<nums[j-1]) {
                swap(nums, j, j - 1);
            }
        }
    }

    public void run() {
        int[] arr = new int[]{1, 3, 2};
        nextPermutation(arr);
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        new NextPermutation().run();
    }
}

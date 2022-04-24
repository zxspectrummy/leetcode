package leetcode.array;

import java.util.Arrays;

public class TwoSumII {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if ((i == 0) || (nums[i] != nums[i - 1])) {
                int j = Arrays.binarySearch(Arrays.copyOfRange(nums, i + 1, nums.length), target - nums[i]);
                if (j >= 0) {
                    return new int[]{i + 1, i + j + 2};
                }
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 4, 9, 56, 90};
        System.out.println(twoSum(nums, 8));
    }
}

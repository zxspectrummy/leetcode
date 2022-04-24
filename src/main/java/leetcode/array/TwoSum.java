package leetcode.array;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length-1;i++) {
            for(int j=i+1;j<nums.length;j++) {
                if (nums[i]+nums[j]==target)
                    return new int[]{i+1,j+1};
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        System.out.println(twoSum(nums,6));
    }
}

package leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }

    public void run() {
        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
    }

    public static void main(String[] args) {
        new FindDuplicate().run();
    }
}

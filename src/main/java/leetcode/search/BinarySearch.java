package leetcode.search;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BinarySearch {
    public static int search(int[] nums, int target) {
        if ((nums[0]>target)||(nums[nums.length-1]<target))
            return -1;
        int leftBound=0;
        int rightBound=nums.length-1;
        while (rightBound-leftBound>1){
            int midIndex = (rightBound+leftBound)/2;
            if (nums[midIndex]<target) {
                leftBound = midIndex+1;
            } else if  (nums[midIndex]>target) {
                rightBound = midIndex;
            } else {
                return midIndex;
            }
        }
        if (nums[leftBound]==target)
            return leftBound;
        if (nums[rightBound]==target)
            return rightBound;
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,3,5,9,12};
        List<Integer>list = Arrays.stream(arr).filter(n->n>0).boxed().collect(Collectors.toList());
        System.out.println(search(arr,9));
    }
}

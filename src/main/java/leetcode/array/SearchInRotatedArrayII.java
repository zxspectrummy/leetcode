package leetcode.array;

import java.util.Arrays;
import java.util.HashSet;

public class SearchInRotatedArrayII {
    private int searchRotationPoint(int[] arr, int l, int r) {
        System.out.println("searching between l = " + l + " r = " + r);
        if (l >= r) {
            return -1;
        }
        int m = l + (r - l) / 2;
        if (arr[m] <= arr[m + 1]) {
            int leftPos = searchRotationPoint(arr, l, m);
            if (leftPos != -1) {
                return leftPos;
            } else {
                return searchRotationPoint(arr, m + 1, r);
            }
        } else {
            return m;
        }
    }

    private int binarySearch(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }
        if (arr.length == 1) {
            return (arr[0] == target) ? 0 : -1;
        }
        int l = 0;
        int r = arr.length - 1;
        if ((arr[l] > target) || (arr[r] < target))
            return -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] < target) {
                l = m + 1;
            } else if (arr[m] > target) {
                r = m - 1;
            } else {
                return m;
            }
        }
        if (arr[l] == target) {
            return l;
        } else if (arr[r] == target) {
            return r;
        }
        return -1;
    }

    public boolean search(int[] nums, int target) {
        if (nums.length==1) {
            return target==nums[0];
        }
        int k = searchRotationPoint(nums, 0, nums.length - 1);
        int[] arr1 = Arrays.copyOfRange(nums, 0, k + 1);
        int[] arr2 = Arrays.copyOfRange(nums, k + 1, nums.length);
        return ((binarySearch(arr1, target) != -1) || (binarySearch(arr2, target) != -1));
    }

    public void run() {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        //System.out.println(search(new int[]{3,4,4,4,4,4,4,5,5,6,6,6,6,6,6,6,7,7,7,7,7,7,8,8,8,8,8,8,8,9,9,9,9,9,9,9,9,9,10,10,10,-10,-10,-10,-9,-8,-8,-8,-8,-8,-7,-7,-7,-7,-6,-6,-6,-6,-6,-6,-6,-5,-5,-5,-4,-4,-4,-4,-3,-3,-3,-3,-3,-3,-2,-2,-2,-2,-1,-1,0,0,0,1,1,1,1,1,1,2,2,2,2,2,2,2,2,3,3,3},2));
        //System.out.println(search(new int[]{2,3,2},3));
        //System.out.println(search(new int[]{2,3,2},0));
        //System.out.println(search(new int[]{1,0,1,1,1},0));
        //System.out.println(search(new int[]{2, 2, 2, 3, 2, 2, 2}, 3));
        System.out.println(search(new int[]{1,2},2));
        //System.out.println(search(new int[]{1},1));
    }

    public static void main(String[] args) {
        new SearchInRotatedArrayII().run();
    }
}

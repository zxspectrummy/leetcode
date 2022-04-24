package leetcode.array;

import java.util.Arrays;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i=0;i<m;i++) {
            if((target>=matrix[i][0])&&(target<=matrix[i][n-1])) {
                return (Arrays.binarySearch(matrix[i],target)>=0);
            }
        }
        return false;
    }
    public void run() {
        int[][] matrix = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(matrix,3));
    }
    public static void main(String[] args) {
            new SearchMatrix().run();
    }
}

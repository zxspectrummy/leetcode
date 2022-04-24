package leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

public class KWeakestRows {
    public static int[] kWeakestRows(int[][] mat, int k) {
        int[] weakestRows = new int[k];
        int[][] rowStrength = new int[mat.length][2];
        for (int i=0;i<mat.length;i++) {
            int j=0;
            rowStrength[i][0] = i;
            while((j<mat[0].length)&&(mat[i][j]==1))
                j++;
            rowStrength[i][1] = j;
        }
        Arrays.sort(rowStrength, Comparator.comparingInt(arr -> arr[1]));
        for (int i = 0; i < k; i++) {
            weakestRows[i] = rowStrength[i][0];
        }
        return weakestRows;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,1,0,0,0},
            {1,1,1,1,0},
        {1,0,0,0,0},
        {1,1,0,0,0},
        {1,1,1,1,1}};
        System.out.println(kWeakestRows(mat, 3));
    }
}

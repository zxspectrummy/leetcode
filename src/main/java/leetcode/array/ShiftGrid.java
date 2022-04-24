package leetcode.array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShiftGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        if (k%(n*m) == 0)
            return  Arrays.stream(grid).map(row -> Arrays.stream(row).boxed().toList()).collect(Collectors.toList());
        List<Integer> list = new ArrayList<>();
        k = k%(n*m);
        for(int i=0;i<k;i++) {
            list.add(i,grid[(n*m-k+i)/n][(n*m-k+i)%n]);
        }
        for(int i=0;i<m*n-k;i++) {
            list.add(grid[i/n][i%n]);
        }
        List<List<Integer>> result = IntStream.range(0, list.size()).filter(i -> i % n == 0)
            .mapToObj(i -> list.subList(i, Math.min(i + n, list.size())))
            .collect(Collectors.toList());
        return result;
    }

    public static void main(String[] args) {
        new ShiftGrid().run();
    }

    private void run() {
        int[][] grid = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<List<Integer>> result = shiftGrid(grid, 1);
        result.forEach(System.out::println);
    }
}

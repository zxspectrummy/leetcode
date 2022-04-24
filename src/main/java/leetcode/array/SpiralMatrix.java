package leetcode.array;

public class SpiralMatrix {
    public int[][] generateMatrix(int n) {
        /*
        1  2  3  4
        12 13 14 5
        11 16 15 6
        10 9  8  7
        0..n 0..n 0..
        */
        int[][] matrix = new int[n][n];
        int lastNumber = 1;
        for (int k=0;k<n/2;k++) {
            lastNumber = fillSpiral(matrix,lastNumber,k);
        }
        if (n%2!=0) {
            matrix[n/2][n/2]  = n*n;
        }
        return matrix;
    }
    public int fillSpiral(int[][] matrix, int startNumber, int spiralNumber) {
        int n = matrix.length-1;
        int topLeft = startNumber;
        int topRight = topLeft + n-spiralNumber*2;
        int bottomRight = topRight + n-spiralNumber*2;
        int bottomLeft = bottomRight + n-spiralNumber*2;
        for(int i=spiralNumber; i<n-spiralNumber;i++) {
            matrix[spiralNumber][i] = topLeft++;
            matrix[i][n-spiralNumber] = topRight++;
            matrix[n-spiralNumber][n-i] = bottomRight++;
            matrix[n-i][spiralNumber] = bottomLeft++;
        }
        return bottomLeft;
    }

    public static void main(String[] args) {
        new SpiralMatrix().run();
    }

    private void run() {
        System.out.println(generateMatrix(5));
    }
}

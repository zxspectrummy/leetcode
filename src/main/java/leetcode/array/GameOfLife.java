package leetcode.array;

public class GameOfLife {
    class Board {
        int[][] board;
        int n, m;
        Board(int[][] board) {
            this.board = board;
            n = board.length;
            m = board[0].length;
        }
        boolean isAlive(int x, int y) {
            try {
                return board[x][y]>0;
            } catch (IndexOutOfBoundsException e) {
                return false;
            }
        }
        public int getLiveNeighborCount(int x, int y) {
            int count = 0;
            int[] dx = new int[]{0,1,-1,0,-1,1,-1,1};
            int[] dy = new int[]{1,0,0,-1,-1,1,1,-1};
            for(int i=0;i< dx.length;i++) {
                if (isAlive(x+dx[i],y+dy[i]))
                    count++;
            }
            return count;
        }
        public void calculateNewState() {
            for(int i=0;i<n;i++) {
                for(int j=0;j<m;j++) {
                    int neighborCount = getLiveNeighborCount(i,j);
                    if (isAlive(i,j)) {
                        if (neighborCount<2||neighborCount>3) {
                            board[i][j] = 2;
                        }
                    } else {
                        if (neighborCount == 3)  {
                            board[i][j] = -1;
                        }
                    }
                }
            }
        }
        public void update() {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j<m; j++) {
                    if (board[i][j]>1) {
                        board[i][j] = 0;
                    } else if (board[i][j]<0) {
                        board[i][j] = 1;
                    }
                }
            }
        }
    }

    public void gameOfLife(int[][] board) {
        Board b = new Board(board);
        b.calculateNewState();
        b.update();
        System.out.println("bla");
    }

    public static void main(String[] args) {
        new GameOfLife().run();
    }

    private void run() {
        int[][] board = new int[][]{
            {0,1,0,1},
            {0,0,1,0},
            {1,1,1,0},
            {0,0,0,1}};

        /*
        1
        * */
        gameOfLife(board);
    }
}

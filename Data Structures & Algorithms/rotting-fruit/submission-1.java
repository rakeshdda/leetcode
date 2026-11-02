class Solution {
    class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();

        int freshOrange = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                    freshOrange++;
                }
            }
        }

        if (freshOrange == 0) {
            return 0;
        }

        int minute = 0;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int qSize = queue.size();

            for (int u = 0; u < qSize; u++) {
                Pair curr = queue.poll();

                int row = curr.row;
                int col = curr.col;

                for (int i = 0; i < 4; i++) {
                    int newRow = row + dr[i];
                    int newCol = col + dc[i];

                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                        && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.offer(new Pair(newRow, newCol));
                        freshOrange--;
                    }
                }
            }
            minute++;
        }
        if (freshOrange != 0) {
            return -1;
        }
        return minute-1;
    }
}

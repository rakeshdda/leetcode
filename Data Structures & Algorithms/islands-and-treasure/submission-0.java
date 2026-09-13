class Solution {
    class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new Pair(i, j));
                }
            }
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();

            int row = curr.row;
            int col = curr.col;

            for (int i = 0; i < 4; i++) {
                int newRow = row + dr[i];
                int newCol = col + dc[i];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                    if (grid[newRow][newCol] == Integer.MAX_VALUE) {
                        grid[newRow][newCol] = grid[row][col] + 1;
                        queue.offer(new Pair(newRow, newCol));
                    }
                }
            }
        }
    }
}

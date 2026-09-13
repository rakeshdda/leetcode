class Solution {
   
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int maxArea =0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(i, j, grid);

                     maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }
    public int dfs(int row, int col, int [][] grid){
        int rows = grid.length;
        int cols = grid[0].length;

        grid[row][col]=2;
        
        int count =1;

        int[] dr ={-1,0,1,0};
        int[] dc ={0, 1,0,-1};

        for(int i =0; i< 4; i++){
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if(newRow>=0 && newRow < rows && newCol >=0 && newCol < cols){
                if(grid[newRow][newCol] ==1){
                    
                   count += dfs(newRow, newCol, grid);
                }
            }
        }
        return count;
    }
}

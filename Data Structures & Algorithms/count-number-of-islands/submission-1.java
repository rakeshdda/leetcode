class Solution {
    public int numIslands(char[][] grid) {
      int rows =grid.length;
      int cols = grid[0].length;
    
     boolean[][] visited = new boolean[rows][cols];

     int count =0;

      for(int i=0; i< rows; i++){
        for(int j=0; j< cols; j++){
            if(!visited[i][j] && grid[i][j] =='1' ){
                dfs(i, j, visited, grid);
                count++;
            }
        }
      }
      return count;
    }
    public void dfs(int row, int col, boolean[][] visited, char[][] grid){
        int rows = grid.length;
        int cols =grid[0].length;

        visited[row][col] = true;

        int [] dr ={-1,0, 1, 0};
        int [] dc={0, 1, 0, -1};

        for(int i=0; i< 4; i++){
            int newRow = row + dr[i];
            int newCol = col + dc[i];


            if(newRow >=0 && newRow< rows && newCol >=0 && 
            newCol < cols && !visited[newRow][newCol] &&
             grid[newRow][newCol] == '1'){
                dfs(newRow, newCol, visited, grid);
             }
        }
    }
}

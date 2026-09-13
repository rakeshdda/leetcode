class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols =board[0].length;

        Queue<Pair> queue = new LinkedList<>();

        //fot top 
        for(int col =0; col<cols; col++){
            if(board[0][col] == 'O'){
               dfs(0,col, board);
            }
        }
        //for right
        for(int row =0; row< rows; row++){
            if(board[row][cols-1]== 'O'){
                dfs(row, cols-1, board);
            }
        }
        //for bottom
        for(int col =0; col < cols; col++){
            if(board[rows-1][col] == 'O'){
                dfs(rows-1, col , board);
            }
        }

        //for left
        for(int row=0; row< rows; row++){
            if(board[row][0] == 'O'){
                dfs(row, 0, board);
            }
        }

        for(int i=0; i< rows; i++){
            for(int j =0; j< cols; j++){
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }else if( board[i][j] =='O'){
                    board[i][j] ='X';
                }
            }
        }
    }
    public void dfs(int row, int col, char[][] board){
        board[row][col] = 'T';

        int rows = board.length;
        int cols = board[0].length;

        int [] dr = {-1,0,1,0};
        int [] dc = {0,1,0,-1};

        for(int i =0 ; i< 4; i++){
            
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if(newRow >=0 && newRow < rows && newCol >=0 && newCol < cols){
                if(board[newRow][newCol] == 'O'){
                    dfs(newRow, newCol, board);
                }
            }
        }
    }
}

class Solution {
    private int ROWS, COLS;
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;
        for(int r = 0; r < ROWS; r++){
            if(board[r][0] == 'O') capture(board, r, 0);
            if(board[r][COLS - 1] == 'O') capture(board, r, COLS-1);
        }

        for(int c = 0; c < COLS; c++){
            if(board[0][c] == 'O') capture(board, 0, c);
            if(board[ROWS-1][c] == 'O') capture(board, ROWS-1, c);
        }

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(board[r][c] == 'O') board[r][c] = 'X';
                else if(board[r][c] == 'T') board[r][c] = 'O';
            }
        }
    }
    private void capture(char[][] grid, int r, int c){
        if(r < 0 || c < 0 || r >= ROWS || c >= COLS || grid[r][c] != 'O') return;
        grid[r][c] = 'T';
        capture(grid, r+1, c);
        capture(grid, r, c+1);
        capture(grid, r-1, c);
        capture(grid, r, c-1);
    }
}

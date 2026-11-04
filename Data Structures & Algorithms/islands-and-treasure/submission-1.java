class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) q.add(new int[]{i,j});
            }
        }
        if(q.size() == 0) return;
        int[] dirs = new int[]{0,1,0,-1,0};
        while(!q.isEmpty()){
            int[] node = q.poll();
            int r = node[0], c = node[1];
            for(int d = 0; d<4; d++){
                int nr = r + dirs[d], nc = c + dirs[d+1];
                if(nr >= m || nc >= n || nr < 0 || nc < 0 || grid[nr][nc] != Integer.MAX_VALUE) continue;
                q.add(new int[]{nr,nc});
                grid[nr][nc] = grid[r][c] + 1;
            }
        }
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length, fresh = 0;
        int time = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2) q.add(new int[]{i,j});
                else if(grid[i][j] == 1) fresh++;
            }
        }
        int ans = Integer.MIN_VALUE;
        int[] dirs = new int[]{0,1,0,-1,0};
        while(fresh > 0 && !q.isEmpty()){
            int len = q.size();
            for(int l = 0; l < len; l++){
                int[] node = q.poll();
                int r = node[0], c = node[1];
                for(int d = 0; d < 4; d++){
                    int nr = r + dirs[d], nc = c + dirs[d+1];
                    if(nr >= m || nc >= n || nr < 0 || nc < 0 || grid[nr][nc] != 1) continue;
                    q.add(new int[]{nr,nc});
                    grid[nr][nc] = 2;
                    fresh--;
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}

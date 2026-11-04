class Solution {
public:
    void islandsAndTreasure(vector<vector<int>>& grid) {
        queue<pair<int,int>>q;
        int n =grid.size(), m = grid[0].size();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0) q.push({i,j});
            }
        }
        vector<int>dirs = {0,1,0,-1,0};
        int dist = 0;
        while(!q.empty()){
            auto t = q.front();q.pop();
            int r = t.first, c = t.second;
            for(int i=0;i<4;i++){
                int nr = r+dirs[i], nc = c+dirs[i+1];
                if(nr<0 || nc<0 || nr>=n || nc>=m || grid[nr][nc]!=INT_MAX) continue;
                q.push({nr,nc});
                grid[nr][nc] = grid[r][c]+1;
            }
        }
    }
};

class Solution {
    public int uniquePathsWithObstacles(int[][] obs) {
        int m = obs.length, n = obs[0].length;
        int[][] arr = new int[m][n];
        for(int i = 0; i < m; i++){
            if(obs[i][0] == 1) break;
            arr[i][0] = 1;
        }
        for(int j = 0; j < n ;j++){
            if(obs[0][j] == 1) break;
            arr[0][j] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obs[i][j] == 1) continue;
                arr[i][j] += arr[i-1][j] + arr[i][j-1];
            }
        }
        return arr[m-1][n-1];
    }
}
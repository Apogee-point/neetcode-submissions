class Solution {
    int[][] dp;
    int rec(int i, int j, int[] arr){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int st = arr[i] - rec(i+1, j, arr);
        int end = arr[j] - rec(i, j-1, arr);
        return dp[i][j] = Math.max(st, end);
    }
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new int[n][n];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        return rec(0, piles.length-1, piles) > 0 ? true: false;
    }
}
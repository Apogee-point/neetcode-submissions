class Solution {
    int[][] dp;
    int rec(int ind, int b, int[] p){
        if(ind >= p.length) return 0;
        // 1 - sold, 0 - buy
        if(dp[ind][b] != -1) return dp[ind][b]; 
        int ans = rec(ind+1, b, p);
        if(b == 0) ans = Math.max(ans, rec(ind+2, 1-b, p) + p[ind]);
        else ans = Math.max(ans, rec(ind+1, 1-b, p) - p[ind]);
        return dp[ind][b] = ans;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][2];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        return rec(0, 1, prices);
    }
}

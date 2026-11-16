class Solution {
    public int change(int sum, int[] coins) {
        int n = coins.length;
        int[] dp = new int[sum+1];
        dp[0] = 1;
        for(int i = 0; i < n; i++){
            int[] nxt = new int[sum+1];
            nxt[0] = 1;
            for(int j = 1; j <= sum; j++){
                nxt[j] = dp[j];
                if(j >= coins[i]) nxt[j] += nxt[j-coins[i]];
            }
            dp = nxt;
        }
        return dp[sum];
    }
}

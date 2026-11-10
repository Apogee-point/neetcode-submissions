class Solution {
    public int coinChange(int[] coins, int sum) {
        int[] dp = new int[sum+1];
        Arrays.fill(dp, sum+1);
        dp[0] = 0;
        for(int i = 1; i <= sum; i++){
            for(int c: coins){
                if(c <= i) dp[i] = Math.min(dp[i],1 + dp[i-c]);
            }
        }
        return dp[sum] > sum ? -1: dp[sum];
    }
}

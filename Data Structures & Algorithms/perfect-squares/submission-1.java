class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // Base case: 0 squares needed to sum to 0

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                int sq = j * j;
                dp[i] = Math.min(dp[i], dp[i - sq] + 1);
            }
        }
        
        return dp[n];
    }
}
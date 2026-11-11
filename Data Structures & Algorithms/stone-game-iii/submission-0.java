class Solution {
    int[] dp;
    int dfs(int i, int[] stones){
        if(i >= stones.length) return 0;
        int ans = Integer.MIN_VALUE;
        if(dp[i] != -1) return dp[i];
        // take one
        ans = stones[i] - dfs(i+1, stones);
        // take two
        if(i+1 < stones.length) ans = Math.max(ans, stones[i]+stones[i+1] - dfs(i+2, stones));
        // take three
        if(i+2 < stones.length){
            ans = Math.max(ans, stones[i] + stones[i+1] + stones[i+2] - dfs(i+3, stones));
        }
        return dp[i] = ans;
    }
    public String stoneGameIII(int[] stones) {
        dp = new int[stones.length];
        Arrays.fill(dp, -1);
        int out = dfs(0, stones);
        if(out > 0) return "Alice";
        else if(out < 0) return "Bob";
        return "Tie";
    }
}
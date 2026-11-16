class Solution {
    private int[][] dp;
    int dfs(int i, int curr, int sum, int tar, int[] stones){
        if(i == stones.length || curr >= tar){
            return Math.abs(curr - (sum - curr));
        }
        if(dp[i][curr] != -1) return dp[i][curr];
        int take = dfs(i+1, curr+stones[i], sum, tar, stones);
        int notTake = dfs(i+1, curr, sum, tar, stones);
        return dp[i][curr] = Math.min(take, notTake);
    }
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for(int i : stones) sum += i;
        int tar = (sum + 1)/2;
        dp = new int[n][tar+1];
        for(int i = 0; i < stones.length; i++) Arrays.fill(dp[i], -1);
        return dfs(0, 0, sum, tar, stones);
    }
}
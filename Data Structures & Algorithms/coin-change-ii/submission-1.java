class Solution {
    int[][] dp;
    int rec(int ind, int sum, int[] arr){
        if(sum <= 0) return sum == 0 ? 1:0;
        if(ind >= arr.length) return 0;
        if(dp[ind][sum] != -1) return dp[ind][sum];
        int ans = rec(ind, sum-arr[ind], arr);
        ans += rec(ind+1, sum, arr);
        return dp[ind][sum] = ans;

    }
    public int change(int sum, int[] arr) {
        int n = arr.length;
        dp = new int[n][sum+1];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        return rec(0, sum, arr);
    }
}

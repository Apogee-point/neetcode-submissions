class Solution {
    public int combinationSum4(int[] nums, int tar) {
        int[] dp = new int[tar+1];
        dp[0] = 1;
        for(int i = 1; i <= tar; i++){
            for(int j = 0; j < nums.length; j++){
                if(nums[j] <= i) dp[i] += dp[i-nums[j]];
            }
        }
        return dp[tar];
    }
}
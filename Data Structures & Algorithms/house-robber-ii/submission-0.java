class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int first = dp(Arrays.copyOfRange(nums, 1, n));
        int last = dp(Arrays.copyOfRange(nums, 0, n-1));
        return Math.max(first, last);
    }

    public int dp(int[] nums){
        int rob1 = 0, rob2 = 0;
        for(int n: nums){
            int newRob = Math.max(n+rob1, rob2);
            rob1 = rob2;
            rob2 = newRob;
        }
        return rob2;
    }
}

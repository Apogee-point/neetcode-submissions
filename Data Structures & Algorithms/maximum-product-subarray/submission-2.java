class Solution {
    public int maxProduct(int[] nums) {
       int currMax = 1, currMin = 1;
       int ans = nums[0];

       for(int n: nums){
        int tmp = currMax * n;
        currMax = Math.max(n, Math.max(currMax*n, currMin*n));
        currMin = Math.min(n, Math.min(tmp, currMin*n));
        ans = Math.max(ans, currMax);
       }
       return ans;
    }
}

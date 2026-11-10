class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int a = 0, b = 0;
        for(int i = 2; i <= n; i++){
            int oneStep = cost[i-1] + b;
            int twoStep = cost[i-2] + a;
            int c = Math.min(oneStep, twoStep);
            a = b;
            b = c;
        }
        return b;
    }
}

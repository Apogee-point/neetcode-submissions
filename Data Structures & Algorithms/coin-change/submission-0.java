class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();
    int rec(int sum, int[] coins){
        if(sum == 0) return 0;
        if(memo.containsKey(sum)) return memo.get(sum);
        int ans = (int) 1e9;
        for(int n: coins){
            if(n <= sum) ans = Math.min(ans, 1+rec(sum-n, coins));
        }
        memo.put(sum, ans);
        return ans;
    }
    public int coinChange(int[] coins, int amount) {
        int ans =  rec(amount, coins) ;
        return (ans >= 1e9) ? -1: ans;
    }
}

// rec(amount) 

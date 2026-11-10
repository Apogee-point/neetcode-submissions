class Solution {
    int[] dp;
    int rec(int i, String s){
        if(i >= s.length()) return 1;
        if(s.charAt(i) == '0') return dp[i] = 0;
        if(dp[i] != -1) return dp[i];
        int ans = rec(i+1, s);
        if(i < s.length() -1){
            if(s.charAt(i) == '1' || 
               s.charAt(i) == '2' && s.charAt(i+1) < '7') ans += rec(i+2, s);
        }
        return dp[i] = ans;
    }
    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return rec(0, s);
    }
}

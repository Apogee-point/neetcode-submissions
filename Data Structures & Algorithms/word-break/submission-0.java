class Solution {
    Set<String> st;
    int[] dp;
    public boolean rec(int i, String s){
        if(i == s.length()) return true;
        if(dp[i] != -1){
            if(dp[i] == 1) return true;
            return false;
        }
        boolean ans = false;
        for(int j = i; j < s.length(); j++){
            if(st.contains(s.substring(i, j+1))) ans = ans || rec(j+1, s);
        }
        if(ans) dp[i] = 1;
        else dp[i] = 0;
        return ans;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        st = new HashSet<>(wordDict);
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return rec(0, s);
    }
}

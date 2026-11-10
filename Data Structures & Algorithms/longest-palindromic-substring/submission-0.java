class Solution {
    int n, len, ind;
    public String longestPalindrome(String s) {
        n = s.length(); len = 0; ind = 0;
        for(int i = 0; i < n; i++){
            int l = i, r = i;
            check(l, r, s);
            l = i; r = i+1;
            check(l, r, s);
        }
        return s.substring(ind, ind+len);
    }
    public void check(int l, int r, String s){
        while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
            if(r - l + 1 > len){
                len = r-l+1;
                ind = l;
            }
            l--; r++;
        }
    }
}

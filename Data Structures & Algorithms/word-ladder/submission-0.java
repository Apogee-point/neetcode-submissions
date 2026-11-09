class Solution {
    public int ladderLength(String begin, String end, List<String> words) {
        Set<String> dict = new HashSet<>(words);
        Queue<String> q = new LinkedList<>();
        q.offer(begin);
        int ans = 0;
        while(!q.isEmpty()){
            ans++;
            for(int i = q.size(); i > 0; i--){
                String curr = q.poll();
                if(curr.equals(end)) return ans;
                for(int j = 0; j < curr.length(); j++){
                    for(char c = 'a'; c <= 'z'; c++){
                        if(c == curr.charAt(j)) continue;
                        String nxt = curr.substring(0,j) + c + curr.substring(j+1);
                        if(dict.contains(nxt)){
                            q.offer(nxt);
                            dict.remove(nxt);
                        }
                    }
                }
            }
        }
        return 0;
    }
}

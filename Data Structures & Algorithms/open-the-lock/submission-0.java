class Solution {
    public int openLock(String[] block, String tar) {
        if(tar.equals("0000")) return 0;
        Set<String> vis = new HashSet<>(Arrays.asList(block));
        if(vis.contains("0000")) return -1;
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        vis.add("0000");
        int ans = 0;
        while(!q.isEmpty()){
            ans++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                String top = q.poll();
                for(int l = 0; l < 4; l++){
                    for(int opt: new int[]{1,-1}){
                        char[] arr = top.toCharArray();
                        arr[l] = (char)((arr[l] - '0' + opt + 10)%10 + '0');
                        String next = new String(arr);
                        if(vis.contains(next)) continue;
                        if(next.equals(tar)) return ans;
                        q.offer(next);
                        vis.add(next);
                    }
                }
            }
        }
        return -1;
        
    }
}
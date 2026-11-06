class Solution {
    public boolean canFinish(int n, int[][] pre) {
        int[] indeg = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for(int[] p: pre){
            indeg[p[1]]++;
            adj.get(p[0]).add(p[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indeg[i] == 0) q.offer(i);
        }
        int total = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            total++;
            for(int nxt: adj.get(node)){
                indeg[nxt]--;
                if(indeg[nxt] == 0) q.offer(nxt);
            }
        }
        return total == n;
    }
}

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return Collections.singletonList(0);
        List<Integer>[] adj = new ArrayList[n];
        Queue<Integer> q = new LinkedList<>();
        int[] edgeCnt = new int[n];
        for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for(int[] e: edges){
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        for(int i = 0; i < n; i++){
            edgeCnt[i] = adj[i].size();
            if(edgeCnt[i] == 1) q.offer(i);
        }
        while(!q.isEmpty()){
            if(n <= 2) return new ArrayList<>(q);
            int len = q.size();
            for(int i = 0; i < len; i++){
                int node = q.poll();
                n--;
                for(int nei : adj[node]){
                    edgeCnt[nei]--;
                    if(edgeCnt[nei] == 1) q.offer(nei);
                }
            }
        }
        return new ArrayList<>();
    }
}
class Solution {
    public int[] findOrder(int n, int[][] pre) {
        int[] indeg = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        int[] ans = new int[n];
        int ind = 0;
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
            ans[ind++] = node;
            for(int nxt: adj.get(node)){
                indeg[nxt]--;
                if(indeg[nxt] == 0) q.offer(nxt);
            }
        }
        int[] rev = IntStream.range(0, ans.length)
                                  .map(i -> ans[ans.length - 1 - i])
                                  .toArray();
        if(total !=  n) return new int[]{};
        return rev;
    }
}
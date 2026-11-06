class Solution {
    private List<List<Integer>> adj = new ArrayList<>();
    int[] vis;
    public boolean validTree(int n, int[][] edges) {
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        vis = new int[n];
        for(int[] row: edges){
            adj.get(row[0]).add(row[1]);
            adj.get(row[1]).add(row[0]);
        }
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                cnt++;
                if(dfs(i,-1)){
                    return false;
                }
            }
        }
        return cnt == 1;
    }
    public boolean dfs(int i, int par){
        vis[i] = 1;
        for(int nei : adj.get(i)){
            if(vis[nei] == 0){
                if(dfs(nei, i)) return true;
            }
            else if(nei != par) return true;
        }
        return false;
    }
}

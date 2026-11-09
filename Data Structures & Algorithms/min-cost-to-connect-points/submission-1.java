class Solution {
    public int minCostConnectPoints(int[][] pts) {
        int n = pts.length, cost = 0, cnt = 0;
        ArrayList<int[]> edges = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(i == j) continue;
                int dist = Math.abs(pts[i][0] - pts[j][0]) + Math.abs(pts[i][1] - pts[j][1]);
                edges.add(new int[]{dist, i, j});
            }
        }
        edges.sort((a,b) -> Integer.compare(a[0], b[0]));
        DSU dsu = new DSU(n);
        for(int i = 0; i < edges.size(); i++){
            int x = edges.get(i)[1], y = edges.get(i)[2], w = edges.get(i)[0];

            if(dsu.find(x) != dsu.find(y)){
                dsu.union(x,y);
                cost += w;
                if(++cnt == n-1) break;
            }
        }
        return cost;
        
    }
}

class DSU {
    int[] par;
    int[] rank;

    public DSU(int n){
        par = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            par[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x){
        if(x == par[x]) return x;
        return par[x] = find(par[x]);
    }

    public boolean union(int u, int v){
        int pu = find(u), pv = find(v);
        if(pu == pv) return true;
        if(rank[pu] < rank[pv]) par[pu] = pv;
        else if (rank[pu] > rank[pv]) par[pv] = pu;
        else{
            par[pv] = pu;
            rank[pu]++;
        }
        return true;
    }
}

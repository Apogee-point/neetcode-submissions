class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]  = 0;
        for(int i = 0; i <= k; i++){
            int[] tmp = Arrays.copyOf(dist, n);
            for(int[] edge: flights){
                int u = edge[0], v = edge[1], d = edge[2];
                if(dist[u] == Integer.MAX_VALUE) continue;

                if(dist[u] + d < tmp[v]) tmp[v] = dist[u] + d;
            }
            dist = tmp;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}

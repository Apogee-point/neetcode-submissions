class Solution {
    int[] DIR = new int[]{0, 1, 0, -1, 0};
    public int minimumEffortPath(int[][] arr) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));

        pq.offer(new int[]{0, 0, 0});
        int n = arr.length, m = arr[0].length;
        int[][] dist = new int[n][m];
        for(int i = 0; i < n; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int d = curr[0], x = curr[1], y = curr[2];
            if(d > dist[x][y]) continue;

            if(x == n-1 && y == m-1) return d;
            for(int i = 0; i < 4; i++){
                int nx = x + DIR[i], ny = y + DIR[i+1];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                    int newD = Math.max(d, Math.abs(arr[nx][ny] - arr[x][y]));
                    if(dist[nx][ny] > newD){
                        dist[nx][ny] = newD;
                        pq.offer(new int[]{newD, nx, ny});
                    }
                }
            }

        }
        return 0;

    }
}
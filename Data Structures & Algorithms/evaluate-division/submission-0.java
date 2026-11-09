class Solution {
    public Map<String, List<Pair>> adj = new HashMap<>();
    public double[] calcEquation(List<List<String>> eq, double[] values, List<List<String>> que) {

        // build graph
        for(int i = 0; i < eq.size(); i++){
            String a = eq.get(i).get(0), b = eq.get(i).get(1);
            adj.computeIfAbsent(a, k -> new ArrayList<>()).add(new Pair(b, values[i]));
            adj.computeIfAbsent(b, k -> new ArrayList<>()).add(new Pair(a, 1/values[i]));
        }

        double[] ans = new double[que.size()];
        for(int i = 0; i < que.size(); i++){
            String src = que.get(i).get(0);
            String dest = que.get(i).get(1);
            ans[i] = bfs(src, dest);
        }
        return ans;
    }

    public double bfs(String a, String b){
        if(!adj.containsKey(a) || !adj.containsKey(b)) return -1.0;
        Queue<Pair> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        q.offer(new Pair(a, 1.0));
        vis.add(a);

        while(!q.isEmpty()){
            Pair curr = q.poll();
            String node = curr.node;
            double w = curr.w;
            if(node.equals(b)) return w;

            for(Pair nxt: adj.get(node)){
                if(!vis.contains(nxt.node)){
                    vis.add(nxt.node);
                    q.offer(new Pair(nxt.node, w* nxt.w));
                }
            }
        }
        return -1;
    }

    class Pair {
        String node;
        double w;

        Pair(String node, double w){
            this.node = node;
            this.w = w;
        }
    }
}
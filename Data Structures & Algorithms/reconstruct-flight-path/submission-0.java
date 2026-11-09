class Solution {
    Map<String, PriorityQueue<String>> adj = new HashMap<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> t: tickets){
            adj.computeIfAbsent(t.get(0), k -> new PriorityQueue<>()).add(t.get(1));
        }
        List<String> path = new LinkedList<>();
        dfs("JFK", path);
        return path;
    }

    public void dfs(String src, List<String> path){
        PriorityQueue<String> nxt = adj.get(src);
        while(nxt != null && !nxt.isEmpty()){
            String nxtD = nxt.poll();
            dfs(nxtD, path);
        }
        ((LinkedList<String>) path).addFirst(src);
    }
}

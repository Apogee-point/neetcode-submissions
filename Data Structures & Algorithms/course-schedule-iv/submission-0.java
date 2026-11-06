class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] pre, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        List<Set<Integer>> preArr = new ArrayList<>();
        int[] indeg = new int[n];
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
            preArr.add(new HashSet<>());
        }
        for(int[] row: pre){
            indeg[row[1]]++;
            adj.get(row[0]).add(row[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i =0; i < n; i++){
            if(indeg[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            int node = q.poll();
            for(int i: adj.get(node)){
                indeg[i]--;
                if(indeg[i] == 0) q.offer(i);
                preArr.get(i).add(node);
                preArr.get(i).addAll(preArr.get(node));
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for(int[] row: queries){
            int u = row[0], v = row[1];
            ans.add(preArr.get(v).contains(u));
        }
        return ans;
    }
}
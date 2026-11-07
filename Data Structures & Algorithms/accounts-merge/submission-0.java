class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x){
        if(x != parent[x]) {parent[x] = find(parent[x]);}
        return parent[x];
    }

    public boolean union(int x1, int x2){
        int p1 = find(x1), p2 = find(x2);
        if(p1 == p2) return false;
        if(rank[p2] < rank[p1]){
            parent[p2] = p1;
            rank[p1] += rank[p2];
        }
        else{
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
}


class Solution {
    public List<List<String>> accountsMerge(List<List<String>> acc) {
        int n = acc.size();
        UnionFind uf = new UnionFind(n);
        Map<String, Integer> emailToAcc = new HashMap<>();
        for(int i = 0; i < n; i++){
            List<String> a = acc.get(i);
            for(int j = 1; j < a.size(); j++){
                String email = a.get(j);
                if(emailToAcc.containsKey(email)) uf.union(i, emailToAcc.get(email));
                else emailToAcc.put(email, i);
            }
        }

        // group
        Map<Integer, List<String>> group = new HashMap<>();
        for(Map.Entry<String, Integer> row: emailToAcc.entrySet()){
            String email = row.getKey();
            int accId = row.getValue();
            int lead = uf.find(accId);
            group.computeIfAbsent(lead, k -> new ArrayList<>()).add(email);
        }

        //build
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<Integer, List<String>> row: group.entrySet()){
            int accId = row.getKey();
            List<String> emails = row.getValue();
            Collections.sort(emails);
            List<String> l = new ArrayList<>();
            l.add(acc.get(accId).get(0));
            l.addAll(emails);
            ans.add(l);
        }
        return ans;
    }
}
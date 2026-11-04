class Solution {
public:
    vector<int>p;
    int find(int i){
        if(i==p[i]) return i;
        return p[i] = find(p[i]);
    }
    bool validTree(int n, vector<vector<int>>& edges) {
        p.resize(n);
        for(int i=0;i<n;i++) p[i]=i;
        for(auto i:edges){
            int a = i[0], b = i[1];
            if(find(a)==find(b)) return 0;
            p[find(a)] = find(b);
            n--;
        }
        return n==1;
    }
};

// there must be a single parent and no cycle.

class Solution {
public:
    vector<int>vis;
    bool hasCycle(int i,int p,vector<vector<int>>&g){
        if(vis[i]) return true;
        vis[i] = true;
        for(auto j:g[i]){
            if(j!=p && hasCycle(j,i,g)) return true;
        }
        return false;
    }
    bool validTree(int n, vector<vector<int>>& edges) {
        vector<vector<int>>g(n);
        for(auto i:edges){
            g[i[0]].push_back(i[1]);
            g[i[1]].push_back(i[0]);
        }
        vis.resize(n);
        if(hasCycle(0,-1,g)) return false;
        for(int i=0;i<n;i++){
            if(!vis[i]) return false;
        }
        return true;
    }
};

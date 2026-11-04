class Solution {
public:
    void dfs(int node,vector<vector<int>>&g,vector<int>&vis){
        vis[node]=1;
        for(auto i:g[node]){
            if(!vis[i]) dfs(i,g,vis);
        }
    }
    int countComponents(int n, vector<vector<int>>& edges) {
        vector<vector<int>>g(n,vector<int>(n,0));
        for(auto i:edges){
            g[i[0]].push_back(i[1]);
            g[i[1]].push_back(i[0]);
        }
        int ans = 0;
        vector<int>vis(n,0);
        for(int i=0;i<n;i++){
            if(!vis[i]){ans++;dfs(i,g,vis);}
        }
        return ans;
    }
};

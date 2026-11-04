/**
 * Definition of Interval:
 * class Interval {
 * public:
 *     int start, end;
 *     Interval(int start, int end) {
 *         this->start = start;
 *         this->end = end;
 *     }
 * }
 */

class Solution {
public:
    int minMeetingRooms(vector<Interval>& intervals) {
        vector<int>ends,starts;
        for(auto i:intervals){
            ends.push_back(i.end);
            starts.push_back(i.start);
        }
        sort(begin(ends),end(ends));
        sort(begin(starts),end(starts));
        int cnt = 0, i = 0,j = 0, n = ends.size(),ans = 0;
        while(i<n && j<n){
            if(starts[i]<ends[j]){cnt++;i++;}
            else{cnt--;j++;}
            ans = max(ans,cnt);
        }
        return ans;
    }
};

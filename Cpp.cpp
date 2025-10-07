class Solution {
public:
    int trap(vector<int>& h) {
        int n = h.size();
        int totalWater = 0;
        int i =0;
        int j = n-1;
        int l = h[0];
        int r = h[n-1];
        while(i<=j){
          l = max(l,h[i]);
          r = max(r,h[j]);

          if(l<r){
            int wi = l -h[i];
            totalWater+=wi;
            i++;
          }
          else{
            int wj = r - h[j];
            totalWater+= wj;
            j--;
          }
        }

    return totalWater;   
    }
};

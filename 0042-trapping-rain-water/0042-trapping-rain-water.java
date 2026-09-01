class Solution{
    public int trap(int[] h){
        int l=0,r=h.length-1;
        int lm=0,rm=0,ans=0;
        while(l<r){
            if(h[l]<h[r]){
                lm=Math.max(lm,h[l]);
                ans+=lm-h[l++];
            } 
            else{
                rm=Math.max(rm,h[r]);
                ans+=rm-h[r--];
            }
        }
        return ans;
    }
}
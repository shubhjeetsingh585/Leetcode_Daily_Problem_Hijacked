class Solution{
    public boolean uniformArray(int[] nums1){
        int min=Integer.MAX_VALUE;
        for(int x:nums1) if((x&1)==1) min=Math.min(min,x);
        for(int x:nums1) if((x&1)==0 && min!=Integer.MAX_VALUE && x<min) return false;
        return true;
    }
}
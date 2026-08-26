class Solution{
    public int[] searchRange(int[] nums,int target){
        int f=lowerBound(nums,target);
        if(f==nums.length || nums[f]!=target) return new int[]{-1,-1};
        int l=lowerBound(nums,target+1)-1;
        return new int[]{f,l};
    }
    private int lowerBound(int[] nums,int target){
        int l=0,r=nums.length;
        while(l<r){
            int m=l+(r-l)/2;
            if(nums[m]<target) l=m+1;
            else r=m;
        }
        return l;
    }
}
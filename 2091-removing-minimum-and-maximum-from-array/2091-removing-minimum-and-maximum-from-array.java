class Solution{
    public int minimumDeletions(int[] nums){
        int min=0, max=0;
        int n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]<nums[min]) min=i;
            if(nums[i]>nums[max]) max=i;
        }
        int l=Math.min(min,max) ,r=Math.max(min,max);
        return Math.min(l+1+n-r,Math.min(r+1,n-l));
    }
}
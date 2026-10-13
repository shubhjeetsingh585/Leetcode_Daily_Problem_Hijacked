class Solution{
    public long maxAlternatingSum(int[] nums){
        int n=nums.length;
        for(int i=0;i<n;i++) nums[i] *= nums[i];
        Arrays.sort(nums);
        long res=0;
        for(int i=0;i<n;i++) res+=(i<n/2 ? -1L : 1L)*nums[i];
        return res;
    }
}
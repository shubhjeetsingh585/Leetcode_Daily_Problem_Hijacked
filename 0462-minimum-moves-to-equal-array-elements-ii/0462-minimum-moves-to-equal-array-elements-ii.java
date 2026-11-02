class Solution{
    public int minMoves2(int[] nums){
        Arrays.sort(nums);
        int m=nums[nums.length/2], res=0;
        for(int x:nums) res+= Math.abs(x-m);
        return res;
    }
}
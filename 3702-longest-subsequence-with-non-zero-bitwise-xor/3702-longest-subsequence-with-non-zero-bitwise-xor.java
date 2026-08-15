class Solution{
    public int longestSubsequence(int[] nums){
        int xor=0;
        for(int x:nums) xor^=x;
        if(xor!=0) return nums.length;
        for(int v:nums) if(v!=0) return nums.length-1;
        return 0;
    }
}
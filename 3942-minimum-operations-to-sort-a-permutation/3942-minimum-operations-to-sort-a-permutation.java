class Solution{
    public int minOperations(int[] nums){
        int n=nums.length,z=0;
        for(int i=0;i<n;i++) if(nums[i]==0) z=i;
        int res=Integer.MAX_VALUE;
        for(int s:new int[]{1,-1}){
            boolean val=true;
            for(int i=1;i<n;i++){
                int a=(z+(i-1)*s+n)%n, b=(z+i*s+n)%n;
                if(nums[a]>nums[b]){
                    val=false;
                    break;
                }
            }
            if(val){
                if(s==1) res=Math.min(res,Math.min(z,n-z+2));
                else res=Math.min(res,Math.min(z+2,n-z));
            }
        }
        return res==Integer.MAX_VALUE ? -1 : res;
    }
}
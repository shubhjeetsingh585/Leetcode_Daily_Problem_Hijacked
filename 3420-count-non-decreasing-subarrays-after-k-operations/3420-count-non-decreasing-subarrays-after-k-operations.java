class Solution{
    public long countNonDecreasingSubarrays(int[] nums,int k){
        int n=nums.length,j=n-1;
        long res=0,cost=0;
        Deque<Integer>dq=new ArrayDeque<>();
        for(int i=n-1;i>=0;i--){
            while(!dq.isEmpty()&&nums[dq.peekLast()]<nums[i]){
                int l=dq.pollLast();
                int r=dq.isEmpty()?j+1:dq.peekLast();
                cost+=(long)(r-l)*(nums[i]-nums[l]);
            }
            dq.offerLast(i);
            while(cost>k){
                cost-=nums[dq.peekFirst()]-nums[j];
                if(dq.peekFirst()==j) dq.pollFirst();
                j--;
            }
            res+=j-i+1;
        }
        return res;
    }
}
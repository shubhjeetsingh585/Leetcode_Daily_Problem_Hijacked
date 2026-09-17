class Solution{
    public int minSumOfLengths(int[] arr,int target){
        int n=arr.length, inf=1<<30;
        int[] best=new int[n];
        Arrays.fill(best,inf);
        int ans=inf,min=inf,sum=0,l=0;
        for(int r=0;r<n;r++){
            sum+=arr[r];
            while(sum>target) sum-=arr[l++];
            if(sum==target){
                int len=r-l+1;
                if(l>0) ans=Math.min(ans,len+best[l-1]);
                min=Math.min(min,len);
            }
            best[r]=min;
        }
        return ans==inf ? -1 : ans;
    }
}
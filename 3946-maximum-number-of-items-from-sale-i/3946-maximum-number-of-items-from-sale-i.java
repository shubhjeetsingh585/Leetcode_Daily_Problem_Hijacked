class Solution{
    public int maximumSaleItems(int[][] items,int budget){
        int n=items.length,min=Integer.MAX_VALUE;
        int[] dp=new int[budget+1];
        Arrays.fill(dp,-1000000000);
        dp[0]=0;
        for(int i=0;i<n;i++) min=Math.min(min,items[i][1]);
        for(int i=0;i<n;i++){
            int free=0,price=items[i][1];
            for(int j=0;j<n;j++){
                if(i!=j&&items[j][0]%items[i][0]==0) free++;
            }
            for(int j=budget;j>=price;j--) dp[j]=Math.max(dp[j],dp[j-price]+free+1);
        }
        int res=0;
        for(int i=0;i<=budget;i++){
            if(dp[i]>=0) res=Math.max(res,dp[i]+(budget-i)/min);
        }
        return res;
    }
}